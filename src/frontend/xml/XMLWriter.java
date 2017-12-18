package frontend.xml;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import exceptions.ErrorMessage;
import exceptions.XMLException;

/**
 * An abstrat class that writes xml to a specified path
 * @author Albert
 *
 */
public abstract class XMLWriter {
	private String myPath;
	private Document myDocument;
	/**
	 * creates a new XMLWriter creates the document to be written to
	 * @param path	path to write document to
	 */
	public XMLWriter(String path) {
		myDocument = createDocument(path);
		myDocument.appendChild(createChild());		
	}
	
	/**
	 * Creates a new XMLWriter and creates the document to be written to
	 * @param path	path of file to write to document to
	 * @param root	element to be added to document
	 */
	public XMLWriter(String path, Element root) {
		myDocument = createDocument(path);
		Node toAdd =myDocument.importNode(root, true);
		myDocument.appendChild(toAdd);
	}

	/**
	 * @param path	path to create new document at
	 * @return		a Document created at the specified path
	 */
	private Document createDocument(String path) {
		myPath = path;
		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException e) {
			ErrorMessage error = new ErrorMessage(ErrorMessage.INVALID_PATH);
			error.show();
		}
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new XMLException();
		}
		
		Document doc = docBuilder.newDocument();

		return doc;
	}
	
	/**
	 * creates a child according to to be determined rules
	 * @return
	 */
	public abstract Element createChild();
	
	/**
	 * write the document to the path specified
	 */
	public void write() {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(myDocument);
			StreamResult result = new StreamResult(new File(myPath));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);	
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			ErrorMessage error = new ErrorMessage("Could not write to File");
			error.show();
		}
	}

}

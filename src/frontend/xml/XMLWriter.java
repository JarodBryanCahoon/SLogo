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

public abstract class XMLWriter {
	private String myPath;
	private Document myDocument;
	public XMLWriter(String path) {
		myDocument = createDocument(path);
		myDocument.appendChild(createChild());		
	}
	
	public XMLWriter(String path, Element root) {
		myDocument = createDocument(path);
		myDocument.appendChild(root);
	}

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
		Node toAdd =doc.importNode(root, true);
		doc.appendChild(toAdd);
		return doc;
	}
	
	public abstract Element createChild();
	
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

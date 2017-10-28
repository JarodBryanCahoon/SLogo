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

import exceptions.ErrorMessage;
import exceptions.XMLException;

public abstract class XMLWriter {
	public XMLWriter(String path) {
		Document doc = createDocument(path);
		doc.appendChild(createChild());
		
		write(path, doc);		
	}
	
	public XMLWriter(String path, Element root) {
		Document doc = createDocument(path);
		doc.appendChild(root);
		
		write(path, doc);
	}

	private Document createDocument(String path) {
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
	
	public abstract Element createChild();
	
	private void write(String path, Document doc) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);	
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			ErrorMessage error = new ErrorMessage("Could not write to File");
			error.show();
		}
	}

}

package frontend.xml;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

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

public abstract class XMLWriter {
	public XMLWriter(String path) {
		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException e) {
			ErrorMessage error = new ErrorMessage(ErrorMessage.INVALID_PATH);
			error.show();
		}
		
		Document doc = createDocument();
		
		try {
			write(path, doc);
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			ErrorMessage error = new ErrorMessage("Could not write to File");
			error.show();
		}		
	}
	
	public XMLWriter(String path, Element root) {
		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException e) {
			ErrorMessage error = new ErrorMessage(ErrorMessage.INVALID_PATH);
			error.show();
		}
		
		Document doc = createDocument();
		doc.appendChild(root);
		
		try {
			write(path, doc);
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			ErrorMessage error = new ErrorMessage("Could not write to File");
			error.show();
		}
	}
	
	public abstract Document createDocument();
	
	private void write(String path, Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(path));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);	
	}
}

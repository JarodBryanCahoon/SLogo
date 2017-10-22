package frontend.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import exceptions.XMLException;

public abstract class XMLReader {
	private String myPath;
	private File myXmlFile;
	private Document myDocument;
	public XMLReader(String path) throws XMLException {
		myPath = path;
		try {
			myXmlFile = new File(myPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			myDocument = dBuilder.parse(myXmlFile);
		} catch (Exception e) {
			// TODO
		}
		myDocument.getDocumentElement().normalize();
		readFromFile();
	}
	
	protected abstract void readFromFile() throws XMLException;
	
	protected NodeList getNodeList(String tag) {
		Element root = myDocument.getDocumentElement();
		NodeList nList = myDocument.getElementsByTagName(tag);
		return nList;
	}
	
	protected Document getDocument() {
		return myDocument;
	}
	
	protected String getContent(Element element, String tag) {
		return element.getElementsByTagName(tag).item(0).getTextContent();
	}
}

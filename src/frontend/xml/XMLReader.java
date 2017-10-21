package frontend.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
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
		readFromFile();
	}
	
	protected abstract void readFromFile() throws XMLException;
	
	protected NodeList getNodeList(String tag) {
		myDocument.getDocumentElement().normalize();
		NodeList nList = myDocument.getElementsByTagName(tag);
		return nList;
	}
}

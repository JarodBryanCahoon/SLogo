package frontend.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import exceptions.ErrorMessage;
import exceptions.XMLException;

public abstract class XMLReader {
	public static final String XML_ERROR = "Your XML File was formatted incorrectly!";
	private String myPath;
	private File myXmlFile;
	private Document myDocument;
	public XMLReader(String path) throws XMLException, IOException {
		myPath = path;
		try {
			myXmlFile = new File(myPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			myDocument = dBuilder.parse(myXmlFile);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorMessage eMessage = new ErrorMessage("Could Not Read Config XML File");
			eMessage.show();
			return;
		}
		myDocument.getDocumentElement().normalize();
		readFromFile();
	}
	
	protected abstract void readFromFile() throws XMLException, IOException;
	
	protected Element getElement() {
		Element root = myDocument.getDocumentElement();
		return root;
		
	}
	protected NodeList getNodeList(String tag) {
		Element root = myDocument.getDocumentElement();
		return this.getNodeList(root, tag);
	}
	
	protected NodeList getNodeList(Element e, String tag) {
		NodeList nList = e.getElementsByTagName(tag);
		return nList;
	}
	
	public List<String> getNodeListString(String tag) {
		NodeList nList = getNodeList(tag).item(0).getChildNodes();
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for (int k = 1; k<nList.getLength();k+=2) {
			toReturn.add(nList.item(k).getNodeName());
		}
		
		return toReturn;
	}
	public String getNodeContentString(String tag){
		return getChildNode(tag,1);
	}
	public String getChildNode(String tag,int index) {
		NodeList nList = getNodeList(tag).item(0).getChildNodes();
		return nList.item(index).getTextContent();
	}
	
	protected Document getDocument() {
		return myDocument;
	}
	
	
	protected String getContent(Element element, String tag) {
		return element.getElementsByTagName(tag).item(0).getTextContent();
	}
	
	public static Element createTextElement(Document doc, String tag, String text) {
		Element e = doc.createElement(tag);
		e.appendChild(doc.createTextNode(text));
		return e;
	}
}

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
import frontend.modules.ViewModule;

/**
 * An abstract XMLReader that automatically reads from a specified file
 * @author Albert
 *
 */
public abstract class XMLReader {
	public static final String XML_ERROR = "Your XML File was formatted incorrectly!";
	private String myPath;
	private File myXmlFile;
	private Document myDocument;
	private ViewModule myViewModule;
	/**
	 * Creates a new XMLReader
	 * @param path			path of file to be read from
	 * @throws XMLException
	 * @throws IOException
	 */
	public XMLReader(String path) throws XMLException, IOException {
		instDocument(path);
	}
	
	/**
	 * Creates a new XMLReader
	 * @param path			path of file to be read from
	 * @param view			associated ViewModule
	 * @throws XMLException
	 * @throws IOException
	 */
	public XMLReader(String path, ViewModule view) throws XMLException, IOException {
		myViewModule = view;
		instDocument(path);
	}

	/**
	 * instantiates the document from a path
	 * @param path			path of file to be read from
	 * @throws IOException
	 */
	private void instDocument(String path) throws IOException {
		myPath = path;
		try {
			myXmlFile = new File(myPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			myDocument = dBuilder.parse(myXmlFile);
		} catch (Exception e) {
			ErrorMessage eMessage = new ErrorMessage("Could Not Read Config XML File");
			eMessage.show();
			return;
		}
		myDocument.getDocumentElement().normalize();
		readFromFile();
	}
	
	/**
	 * @return	associated ViewModule
	 * @throws XMLException
	 */
	protected ViewModule getViewModule() throws XMLException {
		if(myViewModule == null) {
			throw new XMLException();
		}
		return myViewModule;
	}
		
	/**
	 * A method to be overriden that specifies how a reader will read from the file
	 * @throws XMLException
	 * @throws IOException
	 */
	protected abstract void readFromFile() throws XMLException, IOException;
	
	/**
	 * @return	get root element of document
	 */
	protected Element getElement() {
		Element root = myDocument.getDocumentElement();
		return root;
		
	}
	protected NodeList getNodeList(String tag) {
		Element root = myDocument.getDocumentElement();
		return this.getNodeList(root, tag);
	}
	
	/**
	 * @param e		xml element to read over
	 * @param tag	tag to search for
	 * @return		List of nodes identifying with that tag
	 */
	protected NodeList getNodeList(Element e, String tag) {
		NodeList nList = e.getElementsByTagName(tag);
		return nList;
	}
	
	protected Document getDocument() {
		return myDocument;
	}
	
	/**
	 * return the first element's text content which is identified by tag
	 * @param element
	 * @param tag
	 * @return
	 */
	protected String getContent(Element element, String tag) {
		return element.getElementsByTagName(tag).item(0).getTextContent();
	}
	
	/**
	 * Adds an element to a document with specified tag, text
	 * @param doc	Document to be added to
	 * @param tag	tag to be associated with new element
	 * @param text	text to be associated with new element
	 * @return
	 */
	public static Element createTextElement(Document doc, String tag, String text) {
		Element e = doc.createElement(tag);
		e.appendChild(doc.createTextNode(text));
		return e;
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
	
	public String getChildNode(String tag, int index) {
		NodeList nList = getNodeList(tag).item(0).getChildNodes();
		return nList.item(index).getTextContent();
	}	
}

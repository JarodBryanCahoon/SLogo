package frontend.menus.strategies;

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
import frontend.modules.Module;
import frontend.modules.ViewModule;
import frontend.popups.TextPromptWindow;
import frontend.xml.PreferenceXMLReader;

/**
 * A MenuItemStrategy class that allows the user to export module preferences to a specified path
 * @author Albert
 *
 */
public class Export extends MenuItemStrategy {
	public Export(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		TextPromptWindow textWindow = new TextPromptWindow("Save", "Load Fire URL..", e -> writeXML(e));
	}

	//https://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
	/**
	 * Writes a new XML file to the specified path
	 * @param path	path to write to
	 */
	private void writeXML(String path) {
//		path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + path;
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

	/**
	 * @return	a document with the preferences of each module in view written as a single element
	 */
	private Document createDocument() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new XMLException();
		}
		
		Document doc = docBuilder.newDocument();
		Element root = doc.createElement(PreferenceXMLReader.RenderTags.RESOURCES.getTag());
		doc.appendChild(root);
		for(Module m : getView().getModules()) {
			Element e = m.getXMLPreferences(doc);
			if(e == null) {
				continue;
			}
			root.appendChild(e);
		}
		return doc;
	}

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

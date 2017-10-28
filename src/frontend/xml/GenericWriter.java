package frontend.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exceptions.XMLException;

public class GenericWriter extends XMLWriter {
	public GenericWriter(String path, Element root) {
		super(path, root);
	}

	@Override
	public Document createDocument() {
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

}

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
	public Element createChild() {
		// do nothing
		return null;
	}

}

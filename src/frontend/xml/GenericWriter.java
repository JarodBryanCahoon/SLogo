package frontend.xml;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GenericWriter extends XMLWriter {
	public GenericWriter(String path, Element root) {
		super(path, root);
	}

	@Override
	public Document createDocument() {
		return null;
	}

}

package frontend.xml;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exceptions.XMLException;

public class ConfigReader extends XMLReader {

	private static final String HEIGHT_TAG = "height";
	private static final String WIDTH_TAG = "width";
	private static final String TITLE_TAG = "title";
	private final String VIEW_TAG = "view";
	private int width;
	private int height;
	private String title;

	public ConfigReader(String path) throws XMLException, IOException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		try {
			Element element = (Element) getDocument().getElementsByTagName(VIEW_TAG).item(0);
			height = Integer.parseInt(getContent(element, HEIGHT_TAG));
			width = Integer.parseInt(getContent(element, WIDTH_TAG));
			title = getContent(element, TITLE_TAG);
		} catch (Exception e) {
			e.printStackTrace();
			throw new XMLException();
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String getTitle() {
		return title;
	}
}

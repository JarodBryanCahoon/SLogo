package frontend.xml;

import java.io.IOException;

import org.w3c.dom.Element;

import exceptions.ErrorMessage;
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
	protected void readFromFile() {
		try {
			Element element = (Element) getDocument().getElementsByTagName(VIEW_TAG).item(0);
			height = Integer.parseInt(getContent(element, HEIGHT_TAG));
			width = Integer.parseInt(getContent(element, WIDTH_TAG));
			title = getContent(element, TITLE_TAG);
		} catch (Exception e) {
			ErrorMessage eMessage = new ErrorMessage("Could not read from file");
			eMessage.show();
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

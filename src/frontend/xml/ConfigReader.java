package frontend.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exceptions.XMLException;

public class ConfigReader extends XMLReader {

	private static final String HEIGHT_TAG = "height";
	private static final String WIDTH_TAG = "width";
	private static final String TITLTE_TAG = "title";
	private final String VIEW_TAG = "view";
	private int width;
	private int height;
	private String title;

	public ConfigReader(String path) throws XMLException {
		super(path);
	}

	@Override
	protected void readFromFile(){
		NodeList nList = getNodeList(VIEW_TAG);
		
		Element element = (Element) nList.item(0);
		width = Integer.parseInt(element.getAttribute(WIDTH_TAG));
		height = Integer.parseInt(element.getAttribute(HEIGHT_TAG));
		title = element.getAttribute(VIEW_TAG);
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

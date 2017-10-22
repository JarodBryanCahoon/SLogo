package frontend.xml;

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

	public ConfigReader(String path) throws XMLException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		NodeList nList = getNodeList("view");
		System.out.println(nList.getLength());
//		
		Element element = (Element) getDocument().getElementsByTagName(VIEW_TAG).item(0);
		try {
			height = Integer.parseInt(element.getElementsByTagName(HEIGHT_TAG).item(0).getFirstChild().getNodeValue());
			width = Integer.parseInt(element.getElementsByTagName(WIDTH_TAG).item(0).getFirstChild().getNodeValue());
			title = element.getElementsByTagName(TITLE_TAG).item(0).getFirstChild().getTextContent();
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

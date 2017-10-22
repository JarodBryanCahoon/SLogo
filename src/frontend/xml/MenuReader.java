package frontend.xml;

import exceptions.XMLException;
import frontend.menus.iMenuItemStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.NodeList;

public class MenuReader extends XMLReader {
	private static final String MENU_TAG = "menu";
	private Map<String, List<String>> menuText;
	private Map<String, iMenuItemStrategy> strategies;
	
	public MenuReader(String path) throws XMLException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		menuText = new HashMap<>();
		strategies = new HashMap<>();
		
		NodeList nList = this.getNodeList(MENU_TAG);
		
		System.out.println(nList.getLength());
		
	}

}

package frontend.xml;

import exceptions.XMLException;
import frontend.menus.iMenuItemStrategy;
import javafx.scene.control.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MenuReader extends XMLReader {
	private static final String TYPE_TAG = "type";
	private static final String ITEM_TAG = "item";
	private static final String MENU_TAG = "menu";
	private Map<String, List<MenuItem>> subMenus;
	private Map<String, iMenuItemStrategy> strategies;
	
	public MenuReader(String path) throws XMLException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		subMenus = new HashMap<>();
		strategies = new HashMap<>();		
		NodeList nList = this.getNodeList(MENU_TAG);
				
		for(int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element menu = (Element) nNode;
				
				Node itemHead = menu.getFirstChild();
				NodeList subItems = menu.getChildNodes();			
				for(int j = 0; j < subItems.getLength(); j++) {
					if(itemHead.getNodeType() == Node.ELEMENT_NODE) {
						Element e = (Element) itemHead;
						System.out.println(e.getElementsByTagName("name").item(0).getTextContent());
					}
					itemHead = itemHead.getNextSibling();
				}
			}
		}
	}
	
	private void createMenuItem(Element menu, Element menuItem) {
		if(getContent(menuItem, TYPE_TAG).equals(MENU_TAG)) {
//			createMenu(menu, menuItem);
		} else {
//			createItem(menu, menuItem);
		}
	}
}

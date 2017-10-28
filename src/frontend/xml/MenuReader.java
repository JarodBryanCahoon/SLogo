package frontend.xml;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.menus.CustomMenuButton;
import frontend.menus.strategies.iMenuItemStrategy;
import frontend.modules.Module;
import frontend.modules.ViewModule;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuReader extends XMLReader {
	private static final String TYPE_TAG = "type";
	private static final String NAME_TAG = "name";
	private static final String ITEM_TAG = "item";
	private static final String MENU_TAG = "menu";
	private static final String STRATEGY_TAG = "strategy";
	private static final String PREFIX = "frontend.menus.strategies.";

	private Map<String, Menu> mySubMenus;
	private ViewModule myViewModule;

	public MenuReader(String path, ViewModule viewModule) throws XMLException, IOException {
		super(path);
		myViewModule = viewModule;
	}

	@Override
	protected void readFromFile() throws XMLException {
		mySubMenus = new LinkedHashMap<>();
		NodeList nList = this.getNodeList(MENU_TAG);

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element menu = (Element) nNode;
				parseMenu(menu);
			}
		}
	}

	protected void parseMenu(Element menu) {
		Node itemHead = menu.getFirstChild();
		NodeList subItems = menu.getChildNodes();
		String menuName = StringLevelParse(itemHead, subItems.getLength(), NAME_TAG);
		Menu newMenu = parseSubMenu(menu, itemHead, subItems.getLength());
		mySubMenus.put(menuName, newMenu);
	}

	private String StringLevelParse(Node head, int length, String tag) throws XMLException {
		Node current = head;
		String name = null;
		for (int i = 0; i < length; i++) {
			if (current.getNodeType() == Node.ELEMENT_NODE) {
				if (current.getNodeName().equals(tag)) {
					return current.getTextContent();					
				}
			}
			current = current.getNextSibling();
		}

		throw new XMLException();
	}

	private Menu parseSubMenu(Element menu, Node head, int length) {
		Menu newMenu = new Menu(StringLevelParse(head, length, NAME_TAG));
		Node current = head;
		for (int j = 0; j < length; j++) {
			if(current == null) {
				continue;
			}
			
			if (current.getNodeType() == Node.ELEMENT_NODE) {
				Element menuItem = (Element) current;				
				if (current.getNodeName().equals(ITEM_TAG)) {
					MenuItem newItem = createMenuItem(menu, menuItem);
					newMenu.getItems().add(newItem);
				}
			}
			current = current.getNextSibling();
		}
		return newMenu;
	}

	private MenuItem createMenuItem(Element menu, Element menuItem) {
		if (getContent(menuItem, TYPE_TAG).equals(MENU_TAG)) {
			int length = menuItem.getChildNodes().getLength();
			Node head = menuItem.getFirstChild();
			while(head.getNodeType() != Node.ELEMENT_NODE) {
				head = head.getNextSibling();
			}
			
			Menu subMenu = parseSubMenu(menuItem, head, length);
			return subMenu;
		} else {
			String name = getContent(menuItem, NAME_TAG);
			MenuItem newItem = new MenuItem(name);
			CustomMenuButton newCustomMenu = null;
			try {
				Class<?> cls = Class.forName(PREFIX + getContent(menuItem, STRATEGY_TAG));
				iMenuItemStrategy strategy = (iMenuItemStrategy) cls.getDeclaredConstructor(ViewModule.class)
						.newInstance(myViewModule); 
				newCustomMenu = new CustomMenuButton(newItem, strategy);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				ErrorMessage eMessage = new ErrorMessage("Could not read in menu buttons");
				eMessage.show();
			}
			
			return newCustomMenu.getItem();
		}
	}
	
	public Map<String, Menu> getSubMenus() {
		return mySubMenus;
	}
}

package frontend.xml;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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
	private Map<MenuItem, iMenuItemStrategy> strategies;
	private ViewModule myViewModule;

	public MenuReader(String path) throws XMLException, IOException {
		super(path);
//		myViewModule = module;
	}

	@Override
	protected void readFromFile() throws XMLException {
		mySubMenus = new HashMap<>();
		strategies = new HashMap<>();
		NodeList nList = this.getNodeList(MENU_TAG);

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			System.out.println(i);
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
//		System.out.println(menuName);
		Menu newMenu = parseSubMenu(menu, itemHead, subItems.getLength());
		mySubMenus.put(menuName, newMenu);
	}

	private String StringLevelParse(Node head, int length, String tag) throws XMLException {
		Node current = head;
		String name = null;
		for (int i = 0; i < length; i++) {
			if (current.getNodeType() == Node.ELEMENT_NODE) {
				if (current.getNodeName().equals(tag)) {
					name = current.getTextContent();
					break;
				}
			}
			current = current.getNextSibling();
		}

		if (name == null) {
			throw new XMLException();
		}
		return name;
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
					createMenuItem(menu, menuItem);
//					MenuItem newItem = createMenuItem(menu, menuItem);
//					newMenu.getItems().add(newItem);
				}
			}
			current = current.getNextSibling();
		}

		return newMenu;
	}

	private MenuItem createMenuItem(Element menu, Element menuItem) {
		if (getContent(menuItem, TYPE_TAG).equals(MENU_TAG)) {
//			System.out.println("menu " + getContent(menu, NAME_TAG));
			int length = menuItem.getChildNodes().getLength();
			Node head = menuItem.getFirstChild();
			while(head.getNodeType() != Node.ELEMENT_NODE) {
				head = head.getNextSibling();
			}
			Element eHead = (Element) head;
//			parseSubMenu(menuItem, head, length);
			 return parseSubMenu(menuItem, head, length);
		} else {
			System.out.println("item " + getContent(menuItem, NAME_TAG));
			String name = getContent(menuItem, NAME_TAG);
			MenuItem newItem = new MenuItem(name);
			CustomMenuButton newCustomMenu = null;
			try {
				System.out.println(getContent(menuItem, STRATEGY_TAG));
				Class cls = Class.forName(PREFIX + getContent(menuItem, STRATEGY_TAG));
				iMenuItemStrategy strategy = (iMenuItemStrategy) cls.getDeclaredConstructor(ViewModule.class)
						.newInstance(myViewModule); 
				newCustomMenu = new CustomMenuButton(newItem, strategy);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
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

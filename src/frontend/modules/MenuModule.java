package frontend.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.menus.MenuFactory;
import frontend.xml.MenuReader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;

public class MenuModule extends Module {
	private static final String MENUREADER_PATH = "src/resources/style/menu.xml";

	public MenuModule(double width, double height) throws Exception {
		super(width, height);
	}

	@Override
	protected Parent createParent() throws Exception {
		Group group = new Group();
		MenuFactory factory = new MenuFactory();
		MenuReader myReader = new MenuReader(MENUREADER_PATH, getViewModule());
		MenuBar myMenu = factory.create(myReader.getSubMenus());
		return myMenu;
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
}

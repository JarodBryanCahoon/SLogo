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
	public MenuModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
	}

	@Override
	protected Parent createParent() throws Exception {
		Group group = new Group();
		MenuFactory factory = new MenuFactory();
		MenuReader myReader = new MenuReader(getClass().getClassLoader().getResource("resources/style/menu.xml").getFile(), getViewModule());
		MenuBar myMenu = factory.create(myReader.getSubMenus());
		return myMenu;
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
}

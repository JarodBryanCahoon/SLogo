package frontend.modules;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exceptions.XMLException;
import frontend.menus.MenuFactory;
import frontend.xml.MenuReader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;

public class MenuModule extends Module {
	private static final String MENUREADER_PATH = "src/resources/style/menu.xml";

	public MenuModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
	}

	@Override
	protected Parent createParent() throws Exception {
		MenuBar myMenu = new MenuBar();
		return myMenu;
	}
	
	private void readMenuBar() throws XMLException, IOException {
		MenuBar root = (MenuBar) getParent();
		MenuFactory factory = new MenuFactory();
		MenuReader myReader = new MenuReader(MENUREADER_PATH, getViewModule());
		MenuBar myMenu = factory.create(myReader.getSubMenus());
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
}

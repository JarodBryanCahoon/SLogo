package frontend.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.menus.MenuFactory;
import frontend.xml.MenuReader;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;

/**
 * A module that holds a menu
 * @author Albert
 *
 */
public class MenuModule extends Module {
	private static final String MENUREADER_PATH = "src/resources/style/menu.xml";

	/**
	 * Creates a new MenuModule
	 * @param width		width of module
	 * @param height	height of module
	 * @param view		associated ViewModule
	 * @throws Exception
	 */
	public MenuModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
	}

	@Override
	protected Parent createParent() throws Exception {
		MenuFactory factory = new MenuFactory();
		MenuReader myReader = new MenuReader(MENUREADER_PATH, getViewModule());
		MenuBar myMenu = factory.create(myReader.getSubMenus());
		myMenu.getStyleClass().add("Window");
		return myMenu;
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// do nothing
		return null;
	}
}

package frontend.menus;

import java.util.Map;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

//https://docs.oracle.com/javafx/2/ui_controls/menu_controls.htm
/**
 * A class that creates a menubar from several submenus
 * @author Albert
 *
 */
public class MenuFactory {	
	/**
	 * Creates a new MenuFactory
	 */
	public MenuFactory() {
		
	}
	
	/**
	 * Creates a new MenuBar from submenus
	 * @param subMenus	a mapping from menutext to menuitem
	 * @return			a fully created menubar
	 */
	public MenuBar create(Map<String, Menu> subMenus) {
		MenuBar nBar = new MenuBar();

		for(String menuText : subMenus.keySet()) {
			Menu subMenu = subMenus.get(menuText);
			nBar.getMenus().add(subMenu);
		}
		return nBar;
	}
}

package frontend.menus;

import java.util.Map;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

//https://docs.oracle.com/javafx/2/ui_controls/menu_controls.htm
public class MenuFactory {	
	public MenuFactory() {
		
	}
	
	public MenuBar create(Map<String, Menu> subMenus) {
		MenuBar nBar = new MenuBar();
		
		for(String menuText : subMenus.keySet()) {
			Menu subMenu = new Menu(menuText);			
			nBar.getMenus().add(subMenu);
		}
		
		return nBar;
	}
}

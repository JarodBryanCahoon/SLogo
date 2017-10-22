package frontend.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

//https://docs.oracle.com/javafx/2/ui_controls/menu_controls.htm
public class MenuFactory {	
	public MenuFactory() {
		
	}
	
	public MenuBar create(Map<String, List<MenuItem>> subMenus) {
		MenuBar nBar = new MenuBar();
		
		for(String menuText : subMenus.keySet()) {
			Menu subMenu = new Menu(menuText);
			
			for(MenuItem item : subMenus.get(menuText)) {				
				if(item instanceof Menu) {
					// assume instantiated and subbuttons added in MenuReader
					Menu doubleSubMenu = (Menu) item;
					subMenu.getItems().add(doubleSubMenu);
					continue;
				}
				
				subMenu.getItems().add(item);
			}
			
			nBar.getMenus().add(subMenu);
		}
		
		return nBar;
	}
}

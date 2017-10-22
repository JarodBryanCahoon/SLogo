package frontend.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

//https://docs.oracle.com/javafx/2/ui_controls/menu_controls.htm
public class MenuFactory {	
	public static MenuBar create(List<List<String>> menuItems, Map<List<String>, String> menuText, Map<String, iMenuItemStrategy> strategies) {
		MenuBar newBar = new MenuBar();
		
		for(List<String> menus : menuItems) {
			Menu newMenu = new Menu(menuText.get(menus));
			for(String items : menus) {
				CustomMenuItem newItem = new CustomMenuItem(strategies.get(items), items);
				newMenu.getItems().add(newItem.getItem());
			}
			newBar.getMenus().add(newMenu);
		}		
		return newBar;
	}
}

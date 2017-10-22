package frontend.menus;

import frontend.modules.Module;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class CustomMenuItem {
	private iMenuItemStrategy myStrategy;
	private MenuItem myMenuItem;
	
	// https://stackoverflow.com/questions/37260118/javafx-menuitem-does-not-react-on-mouseevent-clicked
	public CustomMenuItem(iMenuItemStrategy mItemStrategy, String menuText) {
		myStrategy = mItemStrategy;
		myMenuItem = new MenuItem(menuText);
		myMenuItem.setOnAction(e -> myStrategy.execute());
		// format
	}
	
	protected MenuItem getItem() {
		return myMenuItem;
	}

}

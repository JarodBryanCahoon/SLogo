package frontend.menus;

import frontend.modules.Module;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class CustomMenuButton {
	private iMenuItemStrategy myStrategy;
	private MenuItem myMenuItem;
	
	// https://stackoverflow.com/questions/37260118/javafx-menuitem-does-not-react-on-mouseevent-clicked
	public CustomMenuButton(String menuText, iMenuItemStrategy mItemStrategy) {
		this(new MenuItem(menuText), mItemStrategy);
		// format
	}
	
	public CustomMenuButton(MenuItem item, iMenuItemStrategy mItemStrategy) {
		myMenuItem = item;
		myStrategy = mItemStrategy;
		myMenuItem.setOnAction(e -> myStrategy.execute());
	}
	
	public MenuItem getItem() {
		return myMenuItem;
	}

}

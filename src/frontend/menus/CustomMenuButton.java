package frontend.menus;

import frontend.menus.strategies.iMenuItemStrategy;
import javafx.scene.control.MenuItem;

/**
 * A class that creates a button like object on the menu; executes on click
 * @author Albert
 *
 */
public class CustomMenuButton {
	private iMenuItemStrategy myStrategy;
	private MenuItem myMenuItem;
	
	// https://stackoverflow.com/questions/37260118/javafx-menuitem-does-not-react-on-mouseevent-clicked
	/**
	 * Creates a new CustomMenuButton
	 * @param menuText		Menu text
	 * @param mItemStrategy	strategy to execute on click
	 */
	public CustomMenuButton(String menuText, iMenuItemStrategy mItemStrategy) {
		this(new MenuItem(menuText), mItemStrategy);
		// format
	}
	
	/**
	 * Creates a new CustomMenuButton
	 * @param item			Associated MenuItem
	 * @param mItemStrategy	strategy to execute on click
	 */
	public CustomMenuButton(MenuItem item, iMenuItemStrategy mItemStrategy) {
		myMenuItem = item;
		myStrategy = mItemStrategy;
		myMenuItem.setOnAction(e -> myStrategy.execute());
	}
	
	public MenuItem getItem() {
		return myMenuItem;
	}

}

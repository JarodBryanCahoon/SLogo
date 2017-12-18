package frontend.menus.strategies;

import frontend.modules.ViewModule;

/**
 * An abstract class that defines the behavior of a menu item's click
 * @author Albert
 *
 */
public abstract class MenuItemStrategy implements iMenuItemStrategy {
	private ViewModule myModule;
	/**
	 * Creates a new MenuItemStrategy
	 * @param module	ViewModule associated with this strategy
	 */
	public MenuItemStrategy(ViewModule module) {
		myModule = module;
	}
	
	protected ViewModule getView() {
		return myModule;
	}
}

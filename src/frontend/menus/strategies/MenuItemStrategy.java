package frontend.menus.strategies;

import frontend.modules.ViewModule;

public abstract class MenuItemStrategy implements iMenuItemStrategy {
	private ViewModule myModule;
	public MenuItemStrategy(ViewModule module) {
		myModule = module;
	}
	
	protected ViewModule getView() {
		return myModule;
	}
}

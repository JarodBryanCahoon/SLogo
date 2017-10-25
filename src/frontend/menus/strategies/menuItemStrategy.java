package frontend.menus.strategies;

import frontend.modules.Module;
import frontend.modules.ViewModule;

public abstract class menuItemStrategy implements iMenuItemStrategy {
	private ViewModule myModule;
	public menuItemStrategy(ViewModule module) {
		myModule = module;
	}
	
	protected ViewModule getView() {
		return myModule;
	}
}

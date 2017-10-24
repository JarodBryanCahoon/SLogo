package frontend.menus.strategies;

import frontend.modules.Module;

public abstract class menuItemStrategy implements iMenuItemStrategy {
	private Module myModule;
	public menuItemStrategy(Module module) {
		myModule = module;
	}
	
	protected Module getModule() {
		return myModule;
	}
}

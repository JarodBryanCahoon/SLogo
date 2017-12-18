package frontend.menus.strategies;

import frontend.modules.ViewModule;

/**Allows users to clear the screen through the menu
 * @author lasia
 *
 */
public class Clear extends MenuItemStrategy {

	public Clear(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		getView().getRenderModule().clearScreen();
	}

}

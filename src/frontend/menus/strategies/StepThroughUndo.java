package frontend.menus.strategies;

import frontend.modules.ViewModule;

/**
 * A class that theoretically allows the user to undo a command
 * @author Albert
 *
 */
public class StepThroughUndo extends MenuItemStrategy {
	/**
	 * Creates a new StepThroughUndo
	 * @param module	associated ViewModule
	 */
	public StepThroughUndo(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		getView().getManager().undo();
	}

}

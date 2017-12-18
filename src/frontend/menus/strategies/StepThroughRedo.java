package frontend.menus.strategies;

import frontend.modules.ViewModule;

/**
 * A class that theoretically allows the user to redo an undone command
 * @author Albert
 *
 */
public class StepThroughRedo extends MenuItemStrategy {

	/**
	 * Creates a new StepThroughRedo
	 * @param module	associated ViewModule
	 */
	public StepThroughRedo(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		getView().getManager().redo();
	}

}

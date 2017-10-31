package frontend.menus.strategies;

import frontend.modules.ViewModule;

public class StepThroughUndo extends MenuItemStrategy {
	public StepThroughUndo(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		getView().getManager().undo();
	}

}

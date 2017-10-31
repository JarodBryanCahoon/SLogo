package frontend.menus.strategies;

import frontend.modules.ViewModule;

public class StepThroughRedo extends MenuItemStrategy {

	public StepThroughRedo(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		getView().getManager().redo();
	}

}

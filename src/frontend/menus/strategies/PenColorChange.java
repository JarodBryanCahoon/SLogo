package frontend.menus.strategies;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;
import frontend.modules.ViewModule;

public class PenColorChange extends MenuItemStrategy {
	public PenColorChange(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		// create new window that allows pen color change
	}

}

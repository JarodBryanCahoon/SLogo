package frontend.menus.strategies;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;
import frontend.modules.ViewModule;

public class ImageChange extends MenuItemStrategy {
	public ImageChange(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		// create new window that allows pen color change
	}

}

package frontend.menus.strategies;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;

public class imageChange extends menuItemStrategy {
	public imageChange(Module module) {
		super(module);
		try {
			RenderModule testInst = (RenderModule) module;
		} catch (Exception e) {
			throw new XMLException();
		}
	}

	@Override
	public void execute() {
		RenderModule module = (RenderModule) getView();
		// create new window that allows pen color change
	}

}

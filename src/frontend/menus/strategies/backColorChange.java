package frontend.menus.strategies;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;

public class backColorChange extends menuItemStrategy {
	public backColorChange(Module module) {
		super(module);
		try {
			RenderModule testInst = (RenderModule) module;
		} catch (Exception e) {
			throw new XMLException();
		}
	}

	@Override
	public void execute() {
		RenderModule module = (RenderModule) getModule();
		// create new window that allows color change
	}

}

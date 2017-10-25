package frontend.menus.strategies;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;
import frontend.modules.ViewModule;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class backColorChange extends menuItemStrategy {
	private static final String PROMPT_TEXT = "Change Color...";

	public backColorChange(Module module) {
		super(module);		
	}

	@Override
	public void execute() {
	}

}

package frontend.menus.strategies;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;
import frontend.modules.ViewModule;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class BackColorChange extends MenuItemStrategy {
	private static final String PROMPT_TEXT = "Change Color...";

	public BackColorChange(ViewModule module) {
		super(module);		
	}

	@Override
	public void execute() {
	}

}

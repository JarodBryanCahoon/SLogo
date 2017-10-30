package frontend.menus.strategies;

import exceptions.ErrorMessage;
import frontend.modules.StylizeModule;
import frontend.modules.ViewModule;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ColorChange extends MenuItemStrategy {
	private static final String PROMPT_TEXT = "Change Color...";

	public ColorChange(ViewModule module) {
		super(module);		
	}

	@Override
	public void execute() {
		Stage myStage = new Stage();
		
		StylizeModule style = null;
		try {
			style = new StylizeModule();
		} catch (Exception e) {
			ErrorMessage eMessage = new ErrorMessage("Could not find color properties file");
		}
		Scene scene = new Scene(style.getParent());
		scene.getStylesheets().add("/resources/style/" + "stylesheet2.css");
		
		myStage.setAlwaysOnTop(true);
		myStage.setScene(scene);
		myStage.show();
	}

}

package frontend.menus.strategies;

import java.util.Properties;

import exceptions.ErrorMessage;
import frontend.modules.ConsoleInput;
import frontend.modules.ViewModule;
import frontend.xml.ConfigReader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewWindow extends MenuItemStrategy {
	private static final String configFileName = "src/resources/style/config.xml";
	private Stage myStage;
	private Properties myLangFile;
	public NewWindow(ViewModule module) {
		super(module);
		myStage = new Stage();
	}
	
	public NewWindow(Stage s, Properties langFile) throws Exception {
		super(new ViewModule(0, 0));
		myStage = s;
		myLangFile = langFile;
	}
	
	@Override
	public void execute() {
		try {		
			Font.loadFont(
					  "src/resources/style/Letter Gothic.otf", 
					  10
					);

			ConfigReader configReader = new ConfigReader(configFileName);
			ViewModule view = new ViewModule(configReader.getWidth(), configReader.getHeight());
			if(myLangFile == null) {
				view.changeLanguage(getView().getManager().getLangProperties());
			} else {
				view.changeLanguage(myLangFile);
			}
			Scene scene = new Scene(view.getParent(), configReader.getWidth(), configReader.getHeight());
			myStage.setScene(scene);
			myStage.setTitle(configReader.getTitle());
			myStage.show();
			style(myStage.getScene());

		} catch (Exception e) {
			e.printStackTrace();
			ErrorMessage eMessage = new ErrorMessage("Could Not Create New Window!");
			eMessage.show();
		}
		
	}
	
	private void style(Scene scene) {
		scene.getStylesheets().clear();
		scene.getStylesheets().add("/resources/style/" + "stylesheet2.css");
	}
}

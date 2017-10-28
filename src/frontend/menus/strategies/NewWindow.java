package frontend.menus.strategies;

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
	public NewWindow(ViewModule module) {
		super(module);
		myStage = new Stage();
	}
	
	public NewWindow(Stage s) throws Exception {
		super(new ViewModule(0, 0));
		myStage = s;
	}
	
	@Override
	public void execute() {
		try {		
			Font.loadFont(
					  "src/resources/style/Letter Gothic.otf", 
					  10
					);

			ConfigReader configReader = new ConfigReader(configFileName);
			System.out.println(configReader.getWidth() + " " + configReader.getHeight());
			ViewModule view = new ViewModule(configReader.getWidth(), configReader.getHeight());
			
			Scene scene = new Scene(view.getParent(), configReader.getWidth(), configReader.getHeight());
			myStage.setScene(scene);
			myStage.setTitle(configReader.getTitle());
			myStage.show();
			style(myStage.getScene());
			System.out.println(scene.getHeight());

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

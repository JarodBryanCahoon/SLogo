package test;

import frontend.modules.ConsoleInput;
import frontend.modules.ConsoleModule;
import frontend.modules.Module;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ModulesTester extends Application{
	private int WIDTH= 500;
	private int HEIGHT = 500;
	@Override
	public void start(Stage stage) throws Exception {
		Font.loadFont(
				  ConsoleInput.class.getResource("/resource/style/Letter Gothic.otf").toExternalForm(), 
				  10
				);
		// Change test to whatever module you want
		Module test = new ViewModule (WIDTH,HEIGHT);
		
		Parent parent = test.getParent();
		Scene scene = new Scene(parent);
		scene.getStylesheets().add("/resource/style/" + "stylesheet.css");
		stage.setTitle("Testing");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

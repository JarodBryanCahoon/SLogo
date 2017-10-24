package test;

import frontend.modules.ConsoleModule;
import frontend.modules.Module;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModulesTester extends Application{
	private int WIDTH= 300;
	private int HEIGHT = 500;
	@Override
	public void start(Stage stage) throws Exception {
		
		// Change test to whatever module you want
		Module test = new ConsoleModule (WIDTH,HEIGHT);
		
		Parent parent = test.getParent();
		Scene scene = new Scene(parent);
		stage.setTitle("Testing");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

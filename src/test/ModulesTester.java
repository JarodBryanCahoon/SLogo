package test;

import frontend.windows.ConsoleModule;
import frontend.windows.Modules;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModulesTester extends Application{
	private int WIDTH, HEIGHT = 500;
	@Override
	public void start(Stage stage) {
		
		// Change test to whatever module you want
		Modules test = new ConsoleModule (WIDTH,HEIGHT);
		
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
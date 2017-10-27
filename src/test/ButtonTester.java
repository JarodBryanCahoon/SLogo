package test;

import frontend.menus.strategies.Export;
import frontend.modules.ConsoleInput;
import frontend.modules.ConsoleModule;
import frontend.modules.Module;
import frontend.modules.ViewModule;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonTester extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		ViewModule v = new ViewModule(500, 500);
		Export e = new Export(v);
		e.execute();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

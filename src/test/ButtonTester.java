package test;

import frontend.menus.strategies.ChangeLanguage;
import frontend.menus.strategies.NewWindow;
import frontend.modules.ViewModule;
import javafx.application.Application;
import javafx.stage.Stage;

public class ButtonTester extends Application{

	@Override
	public void start(Stage stage) throws Exception {

		ViewModule v = new ViewModule(500, 500);
		ChangeLanguage e = new ChangeLanguage(v);
		e.execute();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

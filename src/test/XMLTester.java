package test;

import frontend.xml.MenuReader;
import javafx.application.Application;
import javafx.stage.Stage;

public class XMLTester extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(getClass().getClassLoader().getResource("menu.xml").getFile());
		MenuReader mReader = new MenuReader(getClass().getClassLoader().getResource("menu.xml").getFile());
	}	
	
	public static void main(String args[] ) {
		launch(args);
	}
	
}

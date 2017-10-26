package test;

import frontend.menus.strategies.Export;
import frontend.modules.MenuModule;
import frontend.modules.ViewModule;
import frontend.xml.ConfigReader;
import frontend.xml.MenuReader;
import javafx.application.Application;
import javafx.stage.Stage;

public class XMLTester extends Application {
	public final static String configFileName = "resources/style/config.xml";


	@Override
	public void start(Stage arg0) throws Exception {
		ConfigReader configReader = new ConfigReader(getClass().getClassLoader().getResource(configFileName).getPath());
		ViewModule view = new ViewModule(configReader.getWidth(), configReader.getHeight());
		
		Export e = new Export(view);
		e.execute();
	}	
	
	public static void main(String args[] ) {
		launch(args);
	}
	
}

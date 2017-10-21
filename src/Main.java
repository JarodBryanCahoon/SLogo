import java.io.File;

import frontend.modules.Module;
import frontend.modules.ViewModule;
import frontend.xml.ConfigReader;
import frontend.xml.XMLReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private final static String configFileName = "config.xml";
	
	@Override
	public void start(Stage s) {
		try {
			ConfigReader configReader = new ConfigReader(getClass().getClassLoader().getResource(configFileName).getPath());
			ViewModule view = new ViewModule(configReader.getWidth(), configReader.getHeight());
			
			Scene scene = new Scene(view.getParent());
			s.setScene(scene);
			s.setTitle(configReader.getTitle());
			s.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public static void main (String[] args) {
        launch(args);
    }
}

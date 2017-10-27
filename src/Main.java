import frontend.modules.ConsoleInput;
import frontend.modules.ViewModule;
import frontend.xml.ConfigReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	public final static String configFileName = "resources/style/config.xml";
	
	@Override
	public void start(Stage s) {
		try {
			Font.loadFont(
					  ConsoleInput.class.getResource("/resources/style/Letter Gothic.otf").toExternalForm(), 
					  10
					);
			System.out.println(getClass().getResource(configFileName).getPath());

			ConfigReader configReader = new ConfigReader(getClass().getClassLoader().getResource(configFileName).getPath());
			ViewModule view = new ViewModule(configReader.getWidth(), configReader.getHeight());
			
			Scene scene = new Scene(view.getParent());
			s.setScene(scene);
			s.setTitle(configReader.getTitle());
			s.show();
			style(s.getScene());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void style(Scene scene) {
		scene.getStylesheets().clear();
		scene.getStylesheets().add("/resources/style/" + "stylesheet2.css");
	}
	
    public static void main (String[] args) {
        launch(args);
    }
}

import exceptions.ErrorMessage;
import frontend.menus.strategies.NewWindow;
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
//		NewWindow w;
//		try {
//			w = new NewWindow(s);
//			w.execute();
//		} catch (Exception e) {
//			ErrorMessage eMessage = new ErrorMessage("Could not instantiate window!");
//			eMessage.show();
//			return;
//		}
		
		try {
			Font.loadFont(
					  ConsoleInput.class.getResource("/resources/style/Letter Gothic.otf").toExternalForm(), 
					  10
					);
			System.out.println(getClass().getResource(configFileName).getPath());

			ConfigReader configReader = new ConfigReader(getClass().getClassLoader().getResource(configFileName).getPath());
			System.out.println(configReader.getWidth() + " " + configReader.getHeight());
			ViewModule view = new ViewModule(configReader.getWidth(), configReader.getHeight());
			
			Scene scene = new Scene(view.getParent(), configReader.getWidth(), configReader.getHeight());
			s.setScene(scene);
			s.setTitle(configReader.getTitle());
			s.show();
//			style(s.getScene());
			System.out.println(scene.getHeight());

		} catch (Exception e) {
			ErrorMessage eMessage = new ErrorMessage("Could Not Start!");
		}
		
	}
	
    public static void main (String[] args) {
        launch(args);
    }
}

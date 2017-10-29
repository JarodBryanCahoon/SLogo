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
	@Override
	public void start(Stage s) {
		NewWindow w;
		try {
			w = new NewWindow(s);
			w.execute();
		} catch (Exception e) {
			e.printStackTrace();
			ErrorMessage eMessage = new ErrorMessage("Could not instantiate window!");
			eMessage.show();
		}		
	}
	
    public static void main (String[] args) {
        launch(args);
    }
}

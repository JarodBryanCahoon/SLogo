import exceptions.ErrorMessage;
import frontend.menus.strategies.ChangeLanguage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{	
	@Override
	public void start(Stage s) {
		ChangeLanguage w;
		try {
			w = new ChangeLanguage(s);
			w.execute();
		} catch (Exception e) {
			ErrorMessage eMessage = new ErrorMessage("Could not instantiate window!");
			eMessage.show();
		}		
	}
	
    public static void main (String[] args) {
        launch(args);
    }
}

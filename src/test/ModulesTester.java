package test;

import frontend.modules.ConsoleInput;
import frontend.modules.ConsoleModule;
import frontend.modules.MenuModule;
import frontend.modules.Module;
import frontend.modules.StylizeModule;
import frontend.modules.VariableModule;
import frontend.modules.RenderModule;
import frontend.modules.ViewModule;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**Tests an individual module
 * @author lasia
 *
 */
public class ModulesTester extends Application{
	private int WIDTH= 500;
	private int HEIGHT = 500;
	private Scene scene;
	@Override
	public void start(Stage stage) throws Exception {
		
		Font.loadFont(
				  ConsoleInput.class.getResource("/resources/style/Letter Gothic.otf").toExternalForm(), 
				  10
				);
		// Change test to whatever module you want
		ViewModule view = new ViewModule(WIDTH,HEIGHT);
		Module test = new MenuModule (WIDTH,HEIGHT,view);
//		Module test = new StylizeModule (view);
//		StylizeModule test = new StylizeModule
		Parent parent = test.getParent();
		scene = new Scene(parent);
		scene.setOnMouseClicked(e->style());
		
		stage.setTitle("Testing");
		stage.setScene(scene);
		stage.show();
		style();
	}
	
	public void style() {
		scene.getStylesheets().clear();
		scene.getStylesheets().add("/resources/style/" + "stylesheet2.css");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package frontend.popups;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A class that automatically appears to the user on creation 
 * @author Albert
 *
 */
public class PopUp {
	private Stage myStage = new Stage();
	private Scene myScene;
	/**
	 * Creates and shows a new popup
	 * @param parent	parent to be displayed
	 * @param title		title of popup to be displayed
	 */
	public PopUp(Parent parent, String title) {
		myScene = new Scene(parent);
		myStage.setScene(myScene);
		myStage.setTitle(title);
		myStage.show();
	}
	
	/**
	 * closes the popup
	 */
	public void hide() {
		myStage.hide();
	}
}

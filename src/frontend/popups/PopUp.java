package frontend.popups;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PopUp {
	private Stage myStage = new Stage();
	private Scene myScene;
	public PopUp(Parent parent, String title) {
		myScene = new Scene(parent);
		myStage.setScene(myScene);
		myStage.setTitle(title);
		myStage.show();
	}
	
	public void hide() {
		myStage.hide();
	}
}
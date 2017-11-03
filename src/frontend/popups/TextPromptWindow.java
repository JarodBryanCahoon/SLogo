package frontend.popups;

import frontend.menus.strategies.IButtonInterface;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A class that asks the user for text
 * @author Albert
 *
 */
public class TextPromptWindow {
	/**
	 * Creates a popup that asks the user for test
	 * @param buttonText	text on the button for user pressing
	 * @param promptText	text to prompt user
	 * @param buttonMethod	strategy for the button to execute
	 */
	public TextPromptWindow(String buttonText, String promptText, IButtonInterface buttonMethod) {
		Pane myPane = new Pane();
		HBox hBox = new HBox();
		
		TextField tField = new TextField();		
		Button b = new Button(buttonText);
		
		tField.setPromptText(promptText);		
		b.setOnMouseClicked(e -> buttonMethod.useText(tField.getText()));
		
		hBox.getChildren().addAll(tField, b);
		myPane.getChildren().add(hBox);
		PopUp popUp = new PopUp(myPane, "");
		
	}
}

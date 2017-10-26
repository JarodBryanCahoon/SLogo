package exceptions;

import java.awt.Font;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorMessage {
	private static final double ERROR_MARGINS = 0.5;
	private static final String ERROR_TITLE = "Error! Error! Error! Alert!";
	private static final String ERROR_MESSAGE = "We encountered an error:\n";
	
	Stage myStage;
	public ErrorMessage(String error) {
		myStage = new Stage();
		TextArea textArea = new TextArea();
		textArea.setText(ERROR_MESSAGE);
		textArea.appendText(error);
		textArea.setDisable(true);
		// lasia help css
		
		Scene scene = new Scene(textArea);
		myStage.setScene(scene);
		
		myStage.setTitle(ERROR_TITLE);
	}

	public void show() {
		myStage.show();
		myStage.setMinWidth(myStage.getScene().getRoot().getBoundsInLocal().getWidth());
	}
}

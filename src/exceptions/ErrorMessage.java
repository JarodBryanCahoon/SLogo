package exceptions;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ErrorMessage {
	private static final double ERROR_MARGINS = 0.5;
	private static final String ERROR_TITLE = "Error! Error! Error! Alert!";
	private static final String ERROR_MESSAGE = "We encountered an error:\n";
	public static final String INVALID_PATH = "File Path is Invalid";
	
	Stage myStage;
	public ErrorMessage(String error) {
		myStage = new Stage();
		TextArea textArea = new TextArea();
		textArea.setText(ERROR_MESSAGE);
		textArea.appendText(error);
		textArea.setDisable(true);
		// lasia help css
		
		Scene scene = new Scene(textArea);
		scene.getStylesheets().add("Window");
		myStage.initStyle(StageStyle.UNDECORATED);
		myStage.setScene(scene);
	}

	public void show() {
		myStage.show();
		myStage.setMinWidth(myStage.getScene().getRoot().getBoundsInLocal().getWidth());
	}
}

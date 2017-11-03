package exceptions;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * A class that creates a generic error message for the user
 * @author Albert
 * @author Lasia Lo
 *
 */
public class ErrorMessage {
	private static final double ERROR_MARGINS = 0.5;
	private static final String ERROR_TITLE = "Error! Error! Error! Alert!";
	private static final String ERROR_MESSAGE = "We encountered an error:\n";
	public static final String INVALID_PATH = "File Path is Invalid";
	
	private Stage myStage;
	/**
	 * Creates a new ErrorMessage
	 * @param error	error message to be displayed
	 */
	public ErrorMessage(String error) {
		myStage = new Stage();
		TextArea textArea = new TextArea();
		textArea.setText(ERROR_MESSAGE);
		textArea.appendText(error);
		textArea.setDisable(true);
		
		Scene scene = new Scene(textArea);
//		scene.getStylesheets().add("/resources/style/" + "stylesheet2.css");
		textArea.getStyleClass().add("root");
		scene.setOnMouseClicked(e->close());
		myStage.initStyle(StageStyle.UNDECORATED);
		myStage.setAlwaysOnTop(true);
		myStage.setScene(scene);
	}

	/**
	 * display the error message
	 */
	public void show() {
		myStage.show();
		myStage.setMinWidth(myStage.getScene().getRoot().getBoundsInLocal().getWidth());
	}
	
	/**
	 * close the error message
	 */
	private void close() {
		myStage.close();
	}
}

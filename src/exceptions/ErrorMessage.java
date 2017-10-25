package exceptions;

import java.awt.Font;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorMessage {
	private static final double ERROR_MARGINS = 0.5;
	private static final String ERROR_TITLE = "Error! Error! Error!";
	Stage myStage;
	public ErrorMessage(String error) {
		myStage = new Stage();
		VBox vBox = new VBox();
		TextField tField = getMessage(error);
		tField.setAlignment(Pos.CENTER);
        
		vBox.getChildren().add(tField);
		vBox.setMargin(tField, new Insets(ERROR_MARGINS, ERROR_MARGINS, ERROR_MARGINS, ERROR_MARGINS));

		Scene scene = new Scene(vBox);
		myStage.setScene(scene);
		myStage.setTitle(ERROR_TITLE);
	}

	private TextField getMessage(String error) {
		TextField tField = new TextField(error);
		tField.setDisable(true);
        tField.setStyle("-fx-opacity: 1.0;");
		return tField;
	}
	
	public void show() {
		myStage.show();
		myStage.setMinWidth(myStage.getScene().getRoot().getBoundsInLocal().getWidth() * 2);
	}
}

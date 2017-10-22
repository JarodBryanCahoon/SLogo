package frontend.modules;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class TestField{
	private StackPane inputField;
	private TextField inputText;
	private TextFlow textFlow;

	public TestField(int width, int height){
		textFlow = new TextFlow();
		inputField = new StackPane();
		inputField.setMinWidth(width);
		createTextInput();
	}

	private void createTextInput() {
		
		inputText = new TextField();
		inputText.setOnKeyPressed(event -> doSomething(event));
		
		inputField.getChildren().add(inputText);
	}
	private void doSomething(KeyEvent event) {
		
		if (event.getCode() == KeyCode.ENTER)
			System.out.println("Sending out!");
	}

	private boolean isEmpty(TextField text) {
		return text.getText().equals("");
	}

	public Node getText() {
		return inputField;
	}
}


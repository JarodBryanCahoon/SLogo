package frontend.modules;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Group;
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
	private Group inputField;
	private TextField inputText;
	private TextFlow textFlow;

	public TestField(int width, int height){
		textFlow = new TextFlow();
		textFlow.setLayoutX(10.8);
		textFlow.setLayoutY(7.5);
		textFlow.setStyle("-fx-background-color : black");
		inputField = new Group();
		createTextInput();
			
	}

	private void createTextInput() {
		
		inputText = new TextField();
		inputText.setMinWidth(1000);
		inputText.setStyle("-fx-text-fill: black; -fx-font-size: 16;-fx-background-color: gray;");
		inputText.setOnKeyPressed(event -> doSomething(event));
		
		inputField.getChildren().add(inputText);
		inputField.getChildren().add(textFlow);
	}
	private void doSomething(KeyEvent event) {
		textFlow.getChildren().clear();
		String incomingText = inputText.getText();
		if (event.getCode() == KeyCode.BACK_SPACE) {
			incomingText = incomingText.substring(0,incomingText.length()-1);
			System.out.println(incomingText);
		}
		Text a = new Text(incomingText);
//		Text b = new Text("|");
		a.setStyle("-fx-fill: red; -fx-font-size: 16;");
//		b.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
		textFlow.getChildren().add(a);
//		textFlow.getChildren().add(b);
		
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


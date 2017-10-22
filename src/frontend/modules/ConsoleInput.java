package frontend.modules;


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ConsoleInput{
	private Group inputField;
	private TextField inputText;
	private TextFlow textFlow;

	public ConsoleInput(int width, int height){
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


	public Node getText() {
		return inputField;
	}
}


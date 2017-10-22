package frontend.modules;


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;



/**Input field of the console
 * Colors text in accordance to syntax
 * @author lasia lo
 *
 */
public class ConsoleInput extends Module{
	private Group inputField;
	private TextField inputText;
	private TextFlow textFlow;

	public ConsoleInput(int width,int height){
		super(width, height);

	}
	@Override
	protected Parent createParent(int width, int height) {
		inputField = new Group();
		createTextFlow();
		createTextField();
		
		inputField.getChildren().add(inputText);
		inputField.getChildren().add(textFlow);
		return inputField;
	}
	
	private void createTextFlow() {
		textFlow = new TextFlow();
		textFlow.setLayoutX(10.8);
		textFlow.setLayoutY(7.5);
		textFlow.setStyle("-fx-background-color : gray");
	}

	private void createTextField() {
		
		inputText = new TextField();
		inputText.setMinWidth(1000);
		inputText.setStyle("-fx-text-fill: white; -fx-font-size: 16;-fx-background-color: gray;");
		inputText.setOnKeyPressed(event -> doSomething(event));
	}
	private void doSomething(KeyEvent event) {
		textFlow.getChildren().clear();
		String incomingText = inputText.getText();
		if (event.getCode() == KeyCode.BACK_SPACE) {
			incomingText = incomingText.substring(0,incomingText.length()-1);
		}
		
		Text a = new Text(incomingText);
		a.setStyle("-fx-fill: red; -fx-font-size: 16;");
		textFlow.getChildren().add(a);
		
		if (event.getCode() == KeyCode.ENTER) {
			textFlow.getChildren().clear();
			
		}
	}

}


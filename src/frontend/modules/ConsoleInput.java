package frontend.modules;
import javafx.scene.Group;
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
	private Group myParent;
	private TextField inputField;
	private TextFlow syntaxField;
	private InterpreterInterface backend;

	public ConsoleInput(int width,int height,InterpreterInterface backend){
		super(width, height);
		this.backend = backend;
				
		addSyntaxField();
		addInputField(width);
		myParent.getChildren().add(inputField);
		myParent.getChildren().add(syntaxField);
	}
	
	@Override
	protected Parent createParent() {
		myParent = new Group();
		return myParent;
	}
	
	private void addSyntaxField() {
		syntaxField = new TextFlow();
		syntaxField.setLayoutX(10.8);
		syntaxField.setLayoutY(7.5);
		syntaxField.setStyle("-fx-background-color : gray");
	}

	private void addInputField(int width) {
		
		inputField = new TextField();
		inputField.setMinWidth(width);
		inputField.setStyle("-fx-text-fill: white; -fx-font-size: 16;-fx-background-color: gray;");
		inputField.setOnKeyPressed(event -> doSomething(event));
	}
	private void doSomething(KeyEvent event) {
		String incomingText = inputField.getText();
		
		if (event.getCode() == KeyCode.SPACE) {
			createText(incomingText);
		}
		
		if (event.getCode() == KeyCode.BACK_SPACE && !incomingText.equals("")) {
			incomingText = incomingText.substring(0,incomingText.length()-1);
			createText(incomingText);
		}
		
		if (event.getCode() == KeyCode.ENTER) {
			backend.addToHistory(incomingText);
			inputField.setText("");
			syntaxField.getChildren().clear();
		}
	}

	private void createText(String incomingText) {
		syntaxField.getChildren().clear();
		Text a = new Text(incomingText);
		a.setStyle("-fx-fill: red; -fx-font-size: 16;");
		syntaxField.getChildren().add(a);
	}

}


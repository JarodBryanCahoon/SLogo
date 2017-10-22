package frontend.modules;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**Input field of the console
 * Colors text in accordance to syntax
 * @author lasia lo
 *
 */

//TODO: Extract CSS

public class ConsoleInput extends Module{
	private Group myParent;
	private TextField inputField;
	private TextFlow syntaxField;
	private TestBackend backend;
	
	private int test;

	public ConsoleInput(int width,int height,TestBackend backend){
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
		Font.loadFont(
				  ConsoleInput.class.getResource("/resource/style/Letter Gothic.otf").toExternalForm(), 
				  10
				);
		syntaxField = new TextFlow();
		syntaxField.setLayoutX(10.9);
		syntaxField.setLayoutY(6);
		syntaxField.getStyleClass().add("syntaxField");
	}

	private void addInputField(int width) {
		
		inputField = new TextField();
		inputField.setMinWidth(width);
		inputField.getStyleClass().add("inputField");
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
		Text a = new Text(incomingText.substring(0,incomingText.length()));
		a.getStyleClass().add("text");
		syntaxField.getChildren().add(a);
	}

}


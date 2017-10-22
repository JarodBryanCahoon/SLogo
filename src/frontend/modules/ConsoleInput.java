package frontend.modules;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
	private TextArea inputField;
	private TextArea multiInputField;
	private TextFlow syntaxField;
	private TestBackend backend;
	private KeyCombination keyComb;
	
	private int test;

	public ConsoleInput(int width,int height,TestBackend backend){
		super(width, height);
		keyComb = new KeyCodeCombination(KeyCode.ENTER,KeyCombination.SHIFT_DOWN);
		this.backend = backend;
				
//		addmultiField();
		addSyntaxField();
		addInputField(width);
		myParent.getChildren().add(inputField);
		myParent.getChildren().add(syntaxField);
	}
	
	private void addmultiField() {
		multiInputField = new TextArea();
		multiInputField.getStyleClass().add("inputField");
//		multiInputField.setEditable(false);
		myParent.getChildren().add(multiInputField);
		
	}

	@Override
	protected Parent createParent() {
		myParent = new Group();
		return myParent;
	}
	
	private void addSyntaxField() {

		syntaxField = new TextFlow();
		syntaxField.setLayoutX(10);
		syntaxField.setLayoutY(5);
		syntaxField.getStyleClass().add("syntaxField");
	}

	private void addInputField(int width) {
		inputField = new TextArea();
		inputField.setPrefWidth(width);
		inputField.getStyleClass().add("inputField");
		inputField.setWrapText(true);
		inputField.setOnKeyPressed(event -> doSomething(event));
		inputField.textProperty().addListener(text ->doSomethingElse(text));
	}
	
	private Object doSomethingElse(Observable in) {
		String text = inputField.textProperty().getValue();
		createText(text);
		
		return null;
	}

	private void doSomething(KeyEvent event) {
		String text = inputField.textProperty().getValue();
		if (event.getCode() == KeyCode.ENTER) {
			createText(text);
		}
		if (keyComb.match(event)) {
			backend.addToHistory(text);
			inputField.setText("");
			syntaxField.getChildren().clear();
		}
	}

	private void createText(String incomingText) {
		myParent.getChildren().clear();
		myParent.getChildren().add(inputField);
		myParent.getChildren().addAll(backend.getConsole(incomingText));
	}

}


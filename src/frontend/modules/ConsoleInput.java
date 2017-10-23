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


public class ConsoleInput extends Module{
	private Group myParent;
	private TextArea inputField;
	private InfoInterface backend;
	private KeyCombination keyComb;
	

	public ConsoleInput(int width,int height,InfoInterface backend){
		super(width, height);
		keyComb = new KeyCodeCombination(KeyCode.ENTER,KeyCombination.SHIFT_DOWN);
		this.backend = backend;
				
		addInputField(width);
		myParent.getChildren().add(inputField);
	}
	
	@Override
	protected Parent createParent() {
		myParent = new Group();
		return myParent;
	}
	

	private void addInputField(int width) {
		inputField = new TextArea();
		inputField.setPrefWidth(width);
		inputField.getStyleClass().add("inputField");
		inputField.setOnKeyPressed(event -> send(event));
		inputField.textProperty().addListener(text ->updateSyntax(text));
	}
	
	private void updateSyntax(Observable in) {
		String text = inputField.textProperty().getValue();
		createText(text);
	}

	private void send(KeyEvent event) {
		String text = inputField.textProperty().getValue();
		if (keyComb.match(event)) {
			backend.addToHistory(text);
			inputField.setText("");
			createText("");
		}
	}

	private void createText(String incomingText) {
		myParent.getChildren().clear();
		myParent.getChildren().add(inputField);
		myParent.getChildren().addAll(backend.getConsole(incomingText));
	}

}


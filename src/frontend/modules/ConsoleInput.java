package frontend.modules;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.interpreter.Manager;
import exceptions.SyntaxException;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**Input field of the console
 * Colors text in accordance to syntax
 * @author lasia lo
 *
 */

public class ConsoleInput extends Module{
	private static final String CSS_CLASS = "Window";
	private Group myParent;
	private TextArea inputField;
	private Manager backend;
	private KeyCombination keyComb;

	public ConsoleInput(double myWidth,double myHeight, ViewModule view) throws Exception{
		super(myWidth, myHeight, view);
		keyComb = new KeyCodeCombination(KeyCode.ENTER,KeyCombination.SHIFT_DOWN);
		this.backend = view.getManager();
				
		addInputField(myWidth);
		myParent.getChildren().add(inputField);
		stylize();
	}
	
	@Override
	protected Parent createParent() {
		myParent = new Group();
		return myParent;
	}

	private void addInputField(double width) {
		inputField = new TextArea();
		inputField.setPrefWidth(width);
		inputField.setOnKeyPressed(event -> send(event));
		inputField.textProperty().addListener(text ->updateSyntax(text));
	}
	
	private void updateSyntax(Observable in) {
		inputField.setStyle("-fx-border-color: transparent");
		String text = getInputText();
		createText(text);
	}

	private void send(KeyEvent event) {
		String text = getInputText();
		if (keyComb.match(event)) {
			try {
			backend.addToHistory(text);
			inputField.setText("");
			createText("");
			} catch (SyntaxException | NullPointerException e) {
				inputField.setStyle("-fx-border-color: red");
			}
			
		}
	}

	private String getInputText() {
		return inputField.textProperty().getValue();
	}

	private void createText(String incomingText) {
		myParent.getChildren().clear();
		myParent.getChildren().add(inputField);
		myParent.getChildren().addAll(backend.getConsole(incomingText));
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	private void stylize() {
		myParent.getStyleClass().add(CSS_CLASS);
		inputField.getStyleClass().add(CSS_CLASS);
		
	}
}


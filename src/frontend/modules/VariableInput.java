package frontend.modules;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class VariableInput {
	private TextField inputField; 
	public VariableInput(String text) {
		inputField = new TextField(text);
		
		inputField.setOnKeyPressed((e->send(e,"te")));
	}
	private void send(KeyEvent event, String string) {
		String text = inputField.textProperty().getValue();
		if (
		
	}
	
}

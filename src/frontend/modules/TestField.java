package frontend.modules;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TestField{
	private HBox textInput;
	private TextField text;

	public TestField(int width, int height){
		textInput = new HBox();
		textInput.setMinWidth(width);
		createTextInput();
	}

	private void createTextInput() {
		
		text = new TextField();
		text.setOnKeyPressed(event -> doSomething(event));
		textInput.getChildren().add(text);
	}
	private void doSomething(KeyEvent event) {
		int index = textInput.getChildren().indexOf(text);
		if (event.getCode() == KeyCode.SPACE) {
			textInput.getChildren().add(index,new Text(text.getText()+ " "));
			text.setText("");
		}
		if (event.getCode() == KeyCode.BACK_SPACE && text.getText().equals(""))
			if (index != 0)
				textInput.getChildren().remove(index-1);
		if (event.getCode() == KeyCode.ENTER)
			System.out.println("Sending out!");
	}

	public Node getText() {
		return textInput;
	}
}


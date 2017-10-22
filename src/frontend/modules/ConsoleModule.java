package frontend.modules;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class ConsoleModule extends Module {
	private VBox vbox;
	private TextField textField;
	public ConsoleModule(int width, int height) throws Exception {
		super(width, height);
		
	}
	
	@Override
	protected Parent createParent(int width, int height) {
		vbox = new VBox();
		addHistory();
		addMessageBox();
		return vbox;
	}
	
	private void addMessageBox() {
		textField = new TextField();
		textField.setMinSize(, minHeight);
		textField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER)
				send();
		});
		vbox.getChildren().add(textField);
		
		
		}

	private void send() {
		textField.setText("");
//		manager.Command(tobeSent);
	}
	
	private void addHistory() {
		ScrollPane historyPane = new ScrollPane();
		TextArea textArea = new TextArea();
		vbox.getChildren().add(historyPane);
//		List<Object> historyList = backend.getHistory();
	}
	                  

}


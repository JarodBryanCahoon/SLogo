package frontend.modules;

import java.util.ArrayList;
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
import javafx.scene.text.Text;

public class ConsoleModule extends Module {
	private VBox console;
	private VBox history;
	private TextField textField;
	private ScrollPane historyPane;
	
	
	private int myWidth;
	private int myHeight;
	
	private List<String> testStrings = new ArrayList<String>();
	private int k;
	
	public ConsoleModule(int width, int height) throws Exception {
		super(width, height);
		
	}
	
	@Override
	protected Parent createParent(int width, int height) {
		myWidth = width;
		myHeight = height;
		console = new VBox();
//		addHistory();
		addConsoleInput();
		return console;
	}
	
	private void addConsoleInput(){
		ConsoleInput test = new ConsoleInput(myWidth,myHeight);
		console.getChildren().add(test.getText());
	}
 
	private void send() {
		testStrings.add(textField.getText());
		textField.setText("");
		updateHistory();
		k++;
		
//		manager.Command(tobeSent);
	}
	
	private void addHistory() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		historyPane.setMinSize(myWidth,myHeight);
		console.getChildren().add(historyPane);
//		List<Object> historyList = backend.getHistory();
	}
	
	private void updateHistory() {
		history.getChildren().add(new Text(testStrings.get(k)));
	}
	                  

}


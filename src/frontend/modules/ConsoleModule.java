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

	private double myWidth;
	private double myHeight;
	
	public ConsoleModule(double width, double height) throws Exception{
		super(width, height);
	}
	
	@Override
	protected Parent createParent() {
		console = new VBox();
//		addHistory();
//		addMessageBox();
		addSuperTesting();
		return console;
	}
	
	private void addConsoleHistory() throws Exception {
		Module ConsoleHistory = new ConsoleHistory(myWidth,myHeight,backend);
		console.getChildren().add(ConsoleHistory.getParent());
	}

	private void addConsoleInput() throws Exception{
		Module test = new ConsoleInput(myWidth,myHeight,backend);
		console.getChildren().add(test.getParent());
	}
	
	private void addHistory() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		historyPane.setMinSize(getWidth(), getHeight());
		console.getChildren().add(historyPane);
//		List<Object> historyList = backend.getHistory();
	}
	
	private void updateHistory() {
		history.getChildren().add(new Text(testStrings.get(k)));
	}
	                  

}


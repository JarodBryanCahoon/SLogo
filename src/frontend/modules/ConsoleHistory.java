package frontend.modules;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ConsoleHistory extends Module implements Observer {
	private VBox history;
	private ScrollPane historyPane;
	
	public ConsoleHistory(int width, int height, InterpreterInterface backend) {
		super(width, height);
		historyPane.setMinSize(width,height);
		backend.addObserver(this);
	}

	@Override
	protected Parent createParent() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		return historyPane;
	}
	
	@Override
	public void update(Observable backend, Object arg1) {
		Text a = new Text(((InterpreterInterface) backend).getHistory());
		history.getChildren().add(a);
	}
	
	


}

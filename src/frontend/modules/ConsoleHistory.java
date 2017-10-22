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
	
	public ConsoleHistory(int width, int height, InfoFactory backend) {
		super(width, height);
		historyPane.setMinSize(width,height);

		backend.addObserver(this);
	}

	@Override
	protected Parent createParent() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		history.getStyleClass().add("inputField");
		historyPane.getStyleClass().add("inputField");
		return historyPane;
	}
	
	@Override
	public void update(Observable backend, Object arg1) {
		Text a = new Text(((InfoFactory) backend).getHistory());
		
		a.setStyle("-fx-fill: white;-fx-font:16px 'Letter Gothic Std';");
		history.getChildren().add(a);
	}
	
	


}

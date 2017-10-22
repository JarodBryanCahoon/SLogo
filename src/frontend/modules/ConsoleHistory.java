package frontend.modules;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ConsoleHistory extends Module {
	private VBox history;
	private ScrollPane historyPane;
	
	public ConsoleHistory(int width, int height) {
		super(width, height);
	}

	@Override
	protected Parent createParent(int width, int height) {
		history = new VBox();
		historyPane = new ScrollPane(history);
		historyPane.setMinSize(width,height);
//		List<Object> historyList = backend.getHistory();
		return historyPane;
	}
	


}

package frontend.modules;

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ConsoleHistory extends Module {
	private VBox history;
	private ScrollPane historyPane;
	
	public ConsoleHistory(int width, int height) {
		super(width, height);
		historyPane.setMinSize(width,height);
	}

	@Override
	protected Parent createParent() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		return historyPane;
	}
	
	


}

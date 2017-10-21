package frontend.modules;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ConsoleModule extends Module {
	private VBox vbox;
	public ConsoleModule(int width, int height) throws Exception {
		super(width, height);
		
	}
	
	@Override
	protected Parent createParent() {
		vbox = new VBox();
		addMessageBox();
//		addHistory();
		return vbox;
	}
	
	private void addMessageBox() {
		TextField textField = new TextField();
		vbox.getChildren().add(textField);
		}

	private void addHistory() {
		ScrollPane historyPane = new ScrollPane();
		TextArea textArea = new TextArea();
		List<Object> historyList = backend.getHistory();
	}
	                  

}


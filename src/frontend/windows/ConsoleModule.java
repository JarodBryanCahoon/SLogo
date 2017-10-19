package frontend.windows;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ConsoleModule extends Modules {
	public ConsoleModule(int width, int height) {
		super(width, height, new VBox());
		addMessageBox();
		addHistory();
	}

	private void addMessageBox() {
		TextField textField = new TextField();
		myParent.getChildrenUnmodifiable().add(textField);
		}

	private void addHistory() {
		// TODO Auto-generated method stub
		
	}
	                  

}

package frontend.modules;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ConsoleModule extends Module {
	private VBox vbox;
	public ConsoleModule(int width, int height) {
		super(width, height);
		
	}
	
	@Override
	protected Parent createParent() {
		vbox = new VBox();
		addMessageBox();
		addHistory();
		return vbox;
	}
	
	private void addMessageBox() {
		TextField textField = new TextField();
		vbox.getChildren().add(textField);
		}

	private void addHistory() {
		// TODO Auto-generated method stub
		
	}
	                  

}


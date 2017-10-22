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


/**Console Window
 * Contains Console inputfield and history
 * @author lasia
 *
 */

public class ConsoleModule extends Module {
	private VBox console;

	private TextField textField;

	
	
	private int myWidth;
	private int myHeight;
	
	private List<String> testStrings = new ArrayList<String>();
	private int k;
	
	public ConsoleModule(int width, int height){
		super(width, height);
		
	}
	
	@Override
	protected Parent createParent(int width, int height) {
		myWidth = width;
		myHeight = height;
		console = new VBox();
		addConsoleHistory();
		addConsoleInput();
		return console;
	}
	
	private void addConsoleHistory() {
		Module ConsoleHistory = new ConsoleHistory(myWidth,myHeight);
		console.getChildren().add(ConsoleHistory.getParent());
	}

	private void addConsoleInput(){
		Module test = new ConsoleInput(myWidth,myHeight);
		console.getChildren().add(test.getParent());
	}
 
}
	
	                  



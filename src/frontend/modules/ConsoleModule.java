package frontend.modules;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;


/**Console Window
 * Contains Console input and history
 * @author lasia
 *
 */

public class ConsoleModule extends Module {
	private VBox console;

	private int myWidth;
	private int myHeight;
	
	private List<String> testStrings = new ArrayList<String>();
	private int k;
	
	public ConsoleModule(int width, int height){
		super(width, height);
		myWidth = width;
		myHeight = height;
		addConsoleHistory();
		addConsoleInput();
	}
	
	@Override
	protected Parent createParent() {
		console = new VBox();
		
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
	
	                  



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
	private InfoInterface backend;

	private double myWidth;
	private double myHeight;
	
	public ConsoleModule(double width, double height) throws Exception{
		super(width, height);
		backend = new InfoInterface();
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
	
	private void addConsoleHistory() throws Exception {
		Module ConsoleHistory = new ConsoleHistory(myWidth,myHeight,backend);
		console.getChildren().add(ConsoleHistory.getParent());
	}

	private void addConsoleInput() throws Exception{
		Module test = new ConsoleInput(myWidth,myHeight,backend);
		console.getChildren().add(test.getParent());
	}
 
}
	
	                  



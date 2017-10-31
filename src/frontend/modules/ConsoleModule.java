package frontend.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;


/**Console Window
 * Contains Console input and history
 * @author lasia
 *
 */

public class ConsoleModule extends Module {
	private final double PROPORTION = .75;
	private double myWidth;
	private double myHeight;
	private VBox console;
	private ConsoleInput myConsoleInput;
	private ConsoleHistory myConsoleHistory;
	
	public ConsoleModule(double width, double height, ViewModule view) throws Exception{
		super(width, height, view);
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
		double height = myHeight *PROPORTION;
		myConsoleHistory = new ConsoleHistory(myWidth, height, getViewModule());
		console.getChildren().add(myConsoleHistory.getParent());
	}

	
	private void addConsoleInput() throws Exception{
		double height = myHeight *(1-PROPORTION);
		myConsoleInput = new ConsoleInput(myWidth,height, getViewModule());
		console.getChildren().add(myConsoleInput.getParent());
	}
	
	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	} 
}
	
	                  



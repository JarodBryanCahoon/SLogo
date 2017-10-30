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
		Module ConsoleHistory = new ConsoleHistory(myWidth, height, getViewModule());
		console.getChildren().add(ConsoleHistory.getParent());
	}

	
	private void addConsoleInput() throws Exception{
		double height = myHeight *(1-PROPORTION);
		Module test = new ConsoleInput(myWidth,height, getViewModule());
		console.getChildren().add(test.getParent());
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	} 
}
	
	                  



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
	private VBox console;
	private double myWidth;
	private double myHeight;
	
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
		Module ConsoleHistory = new ConsoleHistory(myWidth, myHeight, getViewModule());
		console.getChildren().add(ConsoleHistory.getParent());
	}

	private void addConsoleInput() throws Exception{
		Module test = new ConsoleInput(myWidth,myHeight, getViewModule());
		console.getChildren().add(test.getParent());
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	} 
}
	
	                  



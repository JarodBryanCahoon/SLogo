package frontend.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.xml.ColorReader;
import frontend.xml.ColorReader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**Central control of style
 * @author lasia
 *
 */
public class StylizeModule extends Module {
	private static final String XMLPATH = "resources/style/Colors.xml";
	private VBox myParent;
	private ColorReader myReader;
	
	public StylizeModule(double width, double height) throws Exception {
		super(width, height);
		addSettings();
	}

	@Override
	protected Parent createParent() throws Exception {
		myParent = new VBox();
		String path = getClass().getClassLoader().getResource(XMLPATH).getFile().replace("bin","src");
		path = path.substring(1);
		myReader = new ColorReader("C:\\Users\\lasia\\Documents\\workspace\\slogo_team02\\src\\resources\\style\\Colors.xml");
		return myParent;
	}
	
	private void addSettings() {
		addWords();
		addWindow();
		addRender();
	}

	private void addWords() {
		
	}
	private void addWindow() {
		// TODO Auto-generated method stub
		
	}
	private void addRender() {
		// TODO Auto-generated method stub
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void stylize() {
		myParent.
		
	}



}

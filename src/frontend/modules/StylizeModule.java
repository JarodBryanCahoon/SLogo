package frontend.modules;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.xml.ColorReader;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**Central control of style
 * @author lasia
 *
 */
public class StylizeModule extends Module {
	private static final String XMLPATH = "resources/style/Colors.xml";
	private VBox myParent;
	private ColorReader myReader;
	private GridPane settings;
	
	public StylizeModule(double width, double height) throws Exception {
		super(width, height);
		myParent.setMinWidth(width);	
	}

	@Override
	protected Parent createParent() throws Exception {
		myParent = new VBox();
		String path = getClass().getClassLoader().getResource(XMLPATH).getFile().replace("bin","src");
		path = path.substring(1);
		myReader = new ColorReader("C:\\Users\\lasia\\Documents\\workspace\\slogo_team02\\src\\resources\\style\\Colors.xml");
		addSettings();
		stylize();
		return myParent;
	}
	
	private void addSettings() {
		settings = new GridPane();
		settings.setHgap(25);
		System.out.println("\nTESTING\n");
		addWords("Word",0);
		addWords("Windows",2);
		addWords("Rendering",4);
		myParent.getChildren().add(settings);
		
	}

	private void addWords(String tag,int column) {
		createText(tag, column,0);
		
		List<String> names = myReader.getNodeString(tag);
		for (int k = 0;k<names.size();k++) {
			String name = names.get(k);
			String content = myReader.getNodeContentString(name);
			createText(name,column,k+1);
			createPicker(name,content,column+1,k+1);
		}
	}
	
	
	

	private void createText(String tag, int column,int row) {
		Text title = new Text(tag);
		title.getStyleClass().add("Text");
		settings.add(title,column,row);
	}
	
	private void createPicker(String title,String property,int column, int row) {
		ColorPick colorPick = new ColorPick(myReader, title, property);
		settings.add(colorPick.getColorPicker(), column, row);
		
		
	}
	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	private void stylize() {
		myParent.getStyleClass().add("Window");
		settings.getStyleClass().add("Window");
	}



}

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
		addWords();
		addWindow();
		addRender();
		myParent.getChildren().add(settings);
		
	}

	private void addWords() {
		Text subTitle = createText("Words");
		settings.add(subTitle, 0, 0);
		List<String> words = new ArrayList<String>();
		words = myReader.getWords();
			
		for (int k = 0; k<myReader.getWords().size();k++){
			String name = words.get(k);
			String color = myReader.getChildContent(name);
			ColorPick colorPick = new ColorPick(myReader,name,color);
			Text text = createText(name);
			
			settings.add(text, 0, k+1);
			settings.add(colorPick.getColorPicker(), 1, k+1);
		}
	}

	private Text createText(String word) {
		Text text = new Text(word);
		text.getStyleClass().add("Text");
		return text;
	}

	private void addWindow() {
		Text text = createText("Window");
		ColorPick colorPick = new ColorPick(myReader,"Window",myReader.getChildContent("Window"));
		settings.add(text, 2,1 );
		settings.add(colorPick.getColorPicker(), 3,1);
		
	}
	private void addRender() {
		List<String>words = myReader.getRender();
		
		for (int k = 0; k<myReader.getWords().size()-1;k++){
			String name = words.get(k);
			String color = myReader.getContent(name);
			ColorPick colorPick = new ColorPick(myReader,name,color);
			Text text = createText(name);
			
			settings.add(text, 4, k+1);
			settings.add(colorPick.getColorPicker(), 5, k+1);
		}
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

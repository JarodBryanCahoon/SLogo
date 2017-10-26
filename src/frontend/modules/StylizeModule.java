package frontend.modules;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.xml.ColorReader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**Central control of style
 * @author lasia
 *
 */
public class StylizeModule extends Module {
	private final String GAP = "  ";
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
		addWords();
		addWindow();
		addRender();
		
		myParent.getChildren().add(settings);
		
	}

	private void addWords() {
		List<String> words = myReader.getWords();
		for (int k = 0; k<myReader.getWords().size();k++){
			String word = words.get(k);
			Text text = new Text(word+ GAP);
			text.getStyleClass().add("Text");
			double size = text.getLayoutBounds().getHeight();
			Rectangle rect = createRect(word,size);
			
			settings.add(text, 0, k);
			settings.add(rect, 1, k);
		}
	}

	private Rectangle createRect(String word,double size) {
		Rectangle rect = new Rectangle(size,size);
		rect.getStyleClass().add(word);
		rect.setOnMouseClicked(e->openColorPicker());
		return rect;
	}
	
	private Object openColorPicker() {
		System.out.println("this works!");
		return null;
	}

	private void addWindow() {
		System.out.println(myReader.getContent("Variable"));
	}
	private void addRender() {
		System.out.println(myReader.getRender());
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

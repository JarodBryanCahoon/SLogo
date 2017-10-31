package frontend.modules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exceptions.ErrorMessage;
import frontend.xml.ColorReader;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
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
	private static final int WIDTH = 300;
	private VBox myParent;
	private ColorReader myReader;
	private GridPane settings;
	
	public StylizeModule(ViewModule view) throws Exception {
		super(WIDTH, 0, view);
		myParent.setMinWidth(WIDTH);	
	}

	@Override
	protected Parent createParent() throws Exception {
		myParent = new VBox();
		String path = getClass().getClassLoader().getResource(XMLPATH).getFile().replace("bin","src");
		path = path.substring(1);
		myReader = new ColorReader(System.getProperty("user.dir") + "/src/resources/style/Colors.xml");
		addSettings();
		stylize();
		return myParent;
	}
	
	private void addSettings() {
		settings = new GridPane();
		settings.setHgap(25);
		settings.setVgap(5);
		addWords("Word",0);
		addWords("Windows",2);
		addWords("Rendering",4);
		addRendering(4);
		myParent.getChildren().add(settings);
		
	}

	private void addWords(String tag,int column) {
		createText(tag, column,0);
		
		List<String> names = myReader.getNodeListString(tag);
		for (int k = 0;k<names.size();k++) {
			String name = names.get(k);
			createText(name,column,k+1);
			createPicker(name,1,column+1,k+1);
		}
	}
	private void addRendering(int column) {
		createText("Pen",column,2);
		createPicker("Render",3,column+1,2);
		createText("PenSize",column,3);
		createField(column+1,3);
	}

	private void createText(String tag, int column,int row) {
		Text title = new Text(tag);
		title.getStyleClass().add("Text");
		settings.add(title,column,row);
	}
	
	private void createField(int column, int row) {
		TextField textField = new TextField();
		textField.setOnAction(e->send(textField));
		settings.add(textField, column, row);
	}
	
	private void send(TextField textField) {
		String text = textField.textProperty().getValue();
		try {
			myReader.setColor("Render",5,text);
		} catch (IOException e) {
			ErrorMessage eMessage = new ErrorMessage("Could not render");
			eMessage.show();
		}
	}

	private void createPicker(String title,int index,int column, int row) {
		ColorPick colorPick = new ColorPick(myReader, title, index);
		settings.add(colorPick.getColorPicker(), column, row);
	}

	private void stylize() {
		myParent.getStyleClass().add("Window");
		settings.getStyleClass().add("Window");
	}

	public Parent getParent() {
		return myParent;
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		return null;
	}

}

package frontend.modules;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exceptions.SyntaxException;


/**Displays variables and allows user to directly change them
 * @author lasia
 *
 */
public class VariableModule extends Module{
	private GridPane myParent;
	
	public VariableModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
	}

	
//	TODO:REFACTOR TEXT FACTORY
	@Override
	protected Parent createParent() {
		myParent = new GridPane();
		formatPane();
		addVariables();
		stylize();
		return myParent;
	}
//	TODO:Move to CSS
	private void formatPane() {
		myParent.setVgap(10);
		myParent.setHgap(5);
		
	}


	private void addVariables() {
		Map<String,String> variables= testing();
		Set<String> temp = variables.keySet();
		String[] keys =  temp.toArray(new String[0]);
		for (int k = 0 ; k<variables.size();k++) {
			String key = keys[k];
			Node keyText = createText(key);
			Node valueTextField = createTextField(key,variables.get(key));
			
			myParent.add(keyText,0,k);
			myParent.add(valueTextField,2,k);
		}
	}
	
	private Node createText(String text) {
		Text toReturn = new Text(text);
		toReturn.getStyleClass().add("Text");
		toReturn.getStyleClass().add("Variables");
	
		return toReturn;
	}
	
	private Node createTextField(String key, String input) {
		TextField inputField = new TextField(input);
		inputField.getStyleClass().add("Window");
		inputField.setStyle("-fx-border-color:gray");
		inputField.setOnKeyPressed(e->send(e,key,inputField));
		
		return inputField;
	}


	private void send(KeyEvent event, String key,TextField textField) {
		textField.setStyle("-fx-border-color:gray");
		String text = textField.textProperty().getValue();
		if (event.getCode() == KeyCode.ENTER) {
			try {
				String input = key + "=" + text;
				System.out.println(input);
			}
			catch (SyntaxException | NullPointerException e) {
				textField.setStyle("-fx-border-color: red");
			}
		}
	}


	private Map<String, String> testing() {
		Map<String,String> toReturn = new HashMap<String,String>();
		String[] key = {"a","b","c","d","e"};
		String[] values = {"1","2","3","4","5"};
		for (int k = 0;k<key.length;k++) {
			toReturn.put(key[k], values[k]);
		}
		return toReturn;
	}

	private void stylize() {
		myParent.getStyleClass().add("Window");
	}
	
	

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

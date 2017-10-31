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
import java.util.Observable;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.interpreter.Manager;
import exceptions.SyntaxException;


/**Displays variables and allows user to directly change them
 * @author lasia
 *
 */
public class VariableModule extends Module{
	private static final int HGAP = 5;
	private static final int VGAP = 10;
	private GridPane myParent;
	private Map<String,String> variables;
	private Manager manager;
	
	public VariableModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
		manager = view.getViewModule().getManager();
	}

	
//	TODO:REFACTOR TEXT FACTORY
	@Override
	protected Parent createParent() {
		myParent = new GridPane();
		variables = starting();
		formatPane();
		addVariables();
		stylize();
		return myParent;
	}
//	TODO:Move to CSS
	private void formatPane() {
		myParent.setVgap(VGAP);
		myParent.setHgap(HGAP);
		
	}


	private void addVariables() {
		myParent.getChildren().clear();
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

	
	//TODO: Take out the hardcoded make
	private void send(KeyEvent event, String key,TextField textField) {
		textField.setStyle("-fx-border-color:gray");
		String text = textField.textProperty().getValue();
		if (event.getCode() == KeyCode.ENTER) {
			try {
				String input = "make " + key +" "+ text;
				manager.addToHistory(input);
				
			}
			catch (SyntaxException | NullPointerException e) {
				textField.setStyle("-fx-border-color: red");
			}
		}
	}

	private Map<String, String> starting() {
		Map<String,String> toReturn = new HashMap<String,String>();
		String[] key = {":x"};
		String[] values = {" "};
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

	@Override
	public void update(Observable fromManager,Object arg1) {
		Manager manage = (Manager) fromManager;
		variables = manage.getVariables();
		if (variables.size() != 0)
			addVariables();
	}
}

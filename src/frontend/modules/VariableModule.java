package frontend.modules;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


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
		for (int k = 0 ; k<variables.size();k++) {
			Set<String> temp = variables.keySet();
			String[] keys =  temp.toArray(new String[0]);
			Text keyText = createText(keys[k]);
			Text valueText = createText(variables.get(keys[k]));
			
			myParent.add(keyText,0,k);
			myParent.add(valueText,2,k);
			System.out.print(keys[k]);
			System.out.println(variables.get(keys[k]));
		}
	}
	
	private Text createText(String text) {
		Text toReturn = new Text(text);
		toReturn.getStyleClass().add("Text");
		toReturn.getStyleClass().add("Variables");
		return toReturn;
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

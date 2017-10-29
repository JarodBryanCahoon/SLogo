package frontend.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;


/**Displays variables and allows user to directly change them
 * @author lasia
 *
 */
public class VariableModule extends Module{
	private GridPane myParent;
	
	public VariableModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
	}

	@Override
	protected Parent createParent() {
		
		return null;
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package frontend.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class VariableModule extends Module{
	private GridPane myParent;
	
	public VariableModule(double width, double height) throws Exception {
		super(width, height);
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

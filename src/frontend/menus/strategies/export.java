package frontend.menus.strategies;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.xml.PreferenceXMLReader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class export extends menuItemStrategy {	
	public export(Module module) {
		super(module);
	}

	@Override
	public void execute() {
		Stage s = new Stage();
		
		Scene scene = new Scene(new Group());
		HBox hBox = new HBox();
		TextField tField = new TextField();
		tField.setPromptText("Enter File Url");		
		Button b = new Button("Load");
		b.setOnMouseClicked(e -> writeXML(tField.getText()));			
	}

	private void writeXML(String path) throws XMLException {
		
	}
}

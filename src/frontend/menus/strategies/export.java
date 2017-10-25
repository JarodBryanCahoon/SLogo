package frontend.menus.strategies;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.ViewModule;
import frontend.xml.PreferenceXMLReader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class export extends menuItemStrategy {
	public export(ViewModule module) {
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
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new XMLException();
		}
		
		Document doc = docBuilder.newDocument();
		Element root = doc.createElement(PreferenceXMLReader.RenderTags.RESOURCES.getTag());
		doc.appendChild(root);
		for(Module m : getView().getModules()) {
			Element e = m.getXMLPreferences(doc);
			if(e == null) {
				continue;
			}
			root.appendChild(e);
		}
	}
}

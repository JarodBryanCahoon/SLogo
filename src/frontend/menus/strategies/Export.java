package frontend.menus.strategies;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.ViewModule;
import frontend.xml.PreferenceXMLReader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Export extends MenuItemStrategy {
	public Export(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		Stage s = new Stage();		
		Pane myPane = new Pane();
		HBox hBox = new HBox();
		
		TextField tField = new TextField();		
		Button b = new Button("Save");
		
		tField.setPromptText("Enter File Url");		
		b.setOnMouseClicked(e -> {
			try {
				writeXML(tField.getText());
			} catch (XMLException | TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});	
		
		hBox.getChildren().addAll(tField, b);
		myPane.getChildren().add(hBox);
		Scene scene = new Scene(myPane);
		s.setScene(scene);
		s.show();
	}

	//https://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
	private void writeXML(String path) throws XMLException, TransformerException {
		path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + path;
		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException e) {
			ErrorMessage error = new ErrorMessage("File Could Not Be Created");
			error.show();
		}
		
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
		
		write(path, doc);			

	}

	private void write(String path, Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(path));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);	
	}
}

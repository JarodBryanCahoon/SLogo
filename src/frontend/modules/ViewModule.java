package frontend.modules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import frontend.xml.ModuleStyleReader;
import frontend.xml.XMLReader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewModule extends Module{
	private final String moduleFileName = "modules.xml";
	private Scene myScene;
	
	private List<Module> myModules;
	public ViewModule(int width, int height) throws Exception {
		super(width, height);
		ModuleStyleReader mStyleReader = new ModuleStyleReader(getClass().getClassLoader().getResource(moduleFileName).getFile());
		myModules = mStyleReader.getModules();
	}

	@Override
	protected Parent createParent() throws Exception {
		Group myGroup = new Group();
		for(Module m : myModules) {
			Parent myParent = m.getParent();
			myGroup.getChildren().add(myParent);
		}
		return myGroup;
	}
}

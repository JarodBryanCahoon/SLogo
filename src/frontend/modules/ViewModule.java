package frontend.modules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import frontend.xml.ModuleStyleReader;
import frontend.xml.XMLReader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ViewModule extends Module{
	private final static String moduleFileName = "modules.xml";

	private List<Module> myModules;
	
	public ViewModule(int width, int height) throws Exception {
		super(width, height);
	}
	
	private void displayWindows() {
		for(Module m : myModules) {
			// display m
		}
	}

	@Override
	protected Parent createParent() throws Exception {
		ModuleStyleReader mStyleReader = new ModuleStyleReader(getClass().getClassLoader().getResource(moduleFileName).getFile());
		myModules = mStyleReader.getModules();

		BorderPane myParent = new BorderPane();
		for(Module m : myModules) {
			myParent.getChildren().add(m.getParent());
		}
		return myParent;
	}

}

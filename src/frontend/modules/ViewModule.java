package frontend.modules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import frontend.xml.ModuleStyleReader;
import frontend.xml.XMLReader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ViewModule extends Module{
	private String moduleFileName = "modules.txt";
	
	private List<Module> myModules;
	public ViewModule(int width, int height) throws Exception {
		super(width, height);
		ModuleStyleReader mStyleReader = new ModuleStyleReader(getClass().getClassLoader().getResource(moduleFileName).getFile());
		myModules = mStyleReader.readFromFile();
	}
	
	private void displayWindows() {
		
	}

	@Override
	protected Parent createParent() throws Exception {
		
		return null;
	}

}

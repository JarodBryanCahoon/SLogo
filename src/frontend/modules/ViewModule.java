package frontend.modules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import backend.board.RenderSprite;
import frontend.xml.ModuleStyleReader;
import frontend.xml.XMLReader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ViewModule extends Module{
	private final static String moduleFileName = "resources/style/modules.xml";

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
			if(m instanceof RenderModule) {
				myParent.setCenter(m.getParent());
			} else {
				myParent.getChildren().add(m.getParent());

			}
		}
		
		myParent.setPrefSize(getWidth(), getHeight());
		return myParent;
	}
}

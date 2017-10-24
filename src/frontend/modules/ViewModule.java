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
	
	@Override
	protected Parent createParent() throws Exception {
		ModuleStyleReader mStyleReader = new ModuleStyleReader(getClass().getClassLoader().getResource(moduleFileName).getFile());
		myModules = mStyleReader.getModules();

		BorderPane myParent = new BorderPane(myModules.get(0).getParent(), myModules.get(1).getParent(), myModules.get(2).getParent(), null, null);
		myParent.setPrefSize(getWidth(), getHeight());
//		for(Module m : myModules) {
//			myParent.getChildren().add(m.getParent());
////			System.out.println(m.getParent().getBoundsInLocal().getWidth());
//		}	
//		myParent.setPrefSize(getWidth(), getHeight());
		return myParent;
	}
}

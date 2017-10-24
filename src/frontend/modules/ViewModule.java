package frontend.modules;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import backend.board.RenderSprite;
import frontend.xml.ModuleStyleReader;
import frontend.xml.XMLReader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ViewModule extends Module{
	private static final String SET = "set";

	private final static String moduleFileName = "resources/style/modules.xml";

	private Set<Module> myModules;
	
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
		myModules = mStyleReader.getModules().keySet();
		Map<Module, String> posMap = mStyleReader.getModules();
		BorderPane myParent = new BorderPane();
		
		for(Module module : myModules) {
			try {
				Method method = myParent.getClass().getDeclaredMethod(SET + posMap.get(module), Node.class);
				method.invoke(myParent, module.getParent());
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		
		myParent.setPrefSize(getWidth(), getHeight());
		return myParent;
	}
}

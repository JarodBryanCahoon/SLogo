package frontend.modules;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.xml.ModuleStyleReader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ViewModule extends Module{
	private static final String SET = "set";

	private final static String moduleFileName = "resources/style/modules.xml";

	private Set<Module> myModules;
	
	public ViewModule(int width, int height) throws Exception {
		super(width, height);
	}
	
	public Set<Module> getModules() {
		return myModules;
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

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void stylize() {
		// TODO Auto-generated method stub
		
	}
}

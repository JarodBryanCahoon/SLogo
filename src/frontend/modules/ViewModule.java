package frontend.modules;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.interpreter.Manager;
import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.xml.ModuleStyleReader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**Houses all modules in a central window
 * @author Lasia
 *@author Albert
 */
public class ViewModule extends Module {
	private static final String SET = "set";

	private final static String moduleFileName = "resources/style/modules.xml";
	private RenderModule myRenderModule = null;
	private Set<Module> myModules;
	private Manager myManager;
	private Properties myLanguageProperties;

	public ViewModule(int width, int height) throws Exception {
		super(width, height);
		setViewModule(this);
		myManager = new Manager(this);
		initSubModules();
		for (Module m : myModules) {
			myManager.addObserver(m);
		}
		myManager.initializeTurtles();
	}

	public Manager getManager() {
		return myManager;
	}

	public Set<Module> getModules() {
		return myModules;
	}
	
	public double getLeftOffset() {
		return  ((BorderPane) getParent() ).getLeft().getBoundsInLocal().getWidth();
	}
	
	public double getTopOffset() {
		return ((BorderPane) getParent() ).getTop().getBoundsInLocal().getHeight();
	}

	@Override
	protected Parent createParent() throws Exception {
		return new BorderPane();
	}

	private void initSubModules() throws XMLException, IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException {
		BorderPane myParent = (BorderPane) getParent();
		ModuleStyleReader mStyleReader = new ModuleStyleReader(
				getClass().getClassLoader().getResource(moduleFileName).getFile(), this);
		myModules = mStyleReader.getModules().keySet();
		Map<Module, String> posMap = mStyleReader.getModules();

		for (Module module : myModules) {
			try {
				Method method = myParent.getClass().getDeclaredMethod(SET + posMap.get(module), Node.class);
				method.invoke(myParent, module.getParent());
				if (module instanceof RenderModule) {
					myRenderModule = (RenderModule) module;
				}
			} catch (InvocationTargetException e) {
				ErrorMessage eMessage = new ErrorMessage("Could not create Module Parents");
				eMessage.show();
			}
		}

		if (myRenderModule == null) {
			ErrorMessage eMessage = new ErrorMessage("No Render Module");
			eMessage.show();
		}

		myParent.setPrefSize(getWidth(), getHeight());
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// do nothing
		return null;
	}

	public RenderModule getRenderModule() {
		return myRenderModule;
	}

	public void changeLanguage(Properties langProperties) {
		myLanguageProperties = langProperties;
		myManager.changeLanguage(langProperties);
	}
	
	public Properties getLangProperties() {
		return myLanguageProperties;
	}
}

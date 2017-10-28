package frontend.modules;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import exceptions.ErrorMessage;
import exceptions.XMLException;
import frontend.xml.ModuleStyleReader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class ViewModule extends Module{
	private static final String SET = "set";

	private final static String moduleFileName = "resources/style/modules.xml";
	private RenderModule myRenderModule = null;
	private Set<Module> myModules;
	
	public ViewModule(int width, int height) throws Exception {
		super(width, height);
		initSubModules();
		for(Module m : myModules) {
			m.setViewModule(this);
		}
	}
	
	public Set<Module> getModules() {
		return myModules;
	}

	@Override
	protected Parent createParent() throws Exception {				
		return new BorderPane();
	}
	
	private void initSubModules() throws XMLException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException {
		BorderPane myParent = (BorderPane) getParent();
		ModuleStyleReader mStyleReader = new ModuleStyleReader(getClass().getClassLoader().getResource(moduleFileName).getFile());
		myModules = mStyleReader.getModules().keySet();
		Map<Module, String> posMap = mStyleReader.getModules();
		
		for(Module module : myModules) {
			try {
				Method method = myParent.getClass().getDeclaredMethod(SET + posMap.get(module), Node.class);
				method.invoke(myParent, module.getParent());
				if(module instanceof RenderModule) {
					myRenderModule = (RenderModule) module;
				}
			} catch (InvocationTargetException e) {
				ErrorMessage eMessage = new ErrorMessage("Could not create Module Parents");
				eMessage.show();
			}
		}
		
		if(myRenderModule == null) {
			ErrorMessage eMessage = new ErrorMessage("No Render Module");
			eMessage.show();
		}
		
		myParent.setPrefSize(getWidth(), getHeight());
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RenderModule getRenderModule() {
		return myRenderModule;
	}
	
	protected void stylize() {
		// TODO Auto-generated method stub
		
	}
	
	public void changeLanguage(Properties languageProperties) {
		// backend.changeLanguage(languageProperties);
	}
}

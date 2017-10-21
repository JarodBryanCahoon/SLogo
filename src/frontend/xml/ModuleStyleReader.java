package frontend.xml;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import frontend.modules.Module;

public class ModuleStyleReader extends XMLReader{
	// maybe convert to enum
	private static final String WIDTH_TAG = "width";
	private static final String HEIGHT_TAG = "height";
	private static final String MODULE_TAG = "module";
	private static final String CLASS_TAG = "class";
	private List<Module> myModules;

	public ModuleStyleReader(String path) {
		super(path);
		myModules = new ArrayList<>();
	}

	public List<Module> readFromFile() throws Exception {
		Document document = this.getMyDocument();
		document.getDocumentElement().normalize();
		NodeList nList = document.getElementsByTagName(MODULE_TAG);

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				myModules.add(instFromElement(element));
			}
		}
		return myModules;
	}

	private Module instFromElement(Element element) throws Exception {
		String clsName = element.getAttribute(CLASS_TAG);
		int width = Integer.parseInt(element.getAttribute(WIDTH_TAG));
		int height = Integer.parseInt(element.getAttribute(HEIGHT_TAG));

		Class<?> cls;
		Constructor<?> constructor;
		Module module = null;
		
		try {
			cls = Class.forName(clsName);
			constructor = cls.getDeclaredConstructor(String.class, int.class, int.class);
			module = (Module) constructor.newInstance(clsName, width, height);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO handle exception properly
			e.printStackTrace();
			throw new Exception();
		}		
		return module;
	}
}

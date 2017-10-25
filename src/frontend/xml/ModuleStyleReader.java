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

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;

public class ModuleStyleReader extends XMLReader {
	// maybe convert to enum
	private static final String WIDTH_TAG = "width";
	private static final String HEIGHT_TAG = "height";
	private static final String MODULE_TAG = "module";
	private static final String CLASS_TAG = "class";
	private List<Module> myModules;

	public ModuleStyleReader(String path) throws XMLException, IOException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		myModules = new ArrayList<Module>();
		NodeList nList = this.getNodeList(MODULE_TAG);

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				myModules.add(instFromElement(element));
			}
		}

	}

	public List<Module> getModules() {
		return myModules;
	}

	private Module instFromElement(Element element) throws XMLException {
		String clsName = getContent(element, CLASS_TAG);
		double width = (double) Integer.parseInt(getContent(element, WIDTH_TAG));
		double height = (double) Integer.parseInt(getContent(element, HEIGHT_TAG));

		Class<?> cls;
		Constructor<?> constructor;
		Module module = null;

		try {
			cls = Class.forName(clsName);
			constructor = cls.getDeclaredConstructor(double.class, double.class);
			module = (Module) constructor.newInstance(width, height);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new XMLException();
		}
		return module;
	}
}

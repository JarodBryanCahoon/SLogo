package frontend.xml;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import exceptions.XMLException;
import frontend.modules.Module;
import frontend.modules.RenderModule;

public class ModuleStyleReader extends XMLReader {
	private static final String POSITION_TAG = "position";
	// maybe convert to enum
	private static final String WIDTH_TAG = "width";
	private static final String HEIGHT_TAG = "height";
	private static final String MODULE_TAG = "module";
	private static final String CLASS_TAG = "class";
	private Map<Module, String> myModules;

	public ModuleStyleReader(String path) throws XMLException {
		super(path);
	}

	@Override
	protected void readFromFile() throws XMLException {
		myModules = new HashMap<>();
		NodeList nList = this.getNodeList(MODULE_TAG);

		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				instFromElement(element);
			}
		}

	}

	public Map<Module, String> getModules() {
		return myModules;
	}

	private Module instFromElement(Element element) throws XMLException {
		String clsName = getContent(element, CLASS_TAG);
		double width = (double) Integer.parseInt(getContent(element, WIDTH_TAG));
		double height = (double) Integer.parseInt(getContent(element, HEIGHT_TAG));
		String pos = getContent(element, POSITION_TAG);

		Class<?> cls;
		Constructor<?> constructor;
		Module module = null;

		try {
			cls = Class.forName(clsName);
			constructor = cls.getDeclaredConstructor(double.class, double.class);
			module = (Module) constructor.newInstance(width, height);
			myModules.put(module, pos);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new XMLException();
		}
		return module;
	}
}

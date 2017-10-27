package frontend.modules;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.scene.Parent;

public abstract class Module {
	private double myWidth;
	private double myHeight;
	private Parent myParent;
	private ViewModule myViewModule;

	public Module(double width, double height, ViewModule view) throws Exception {
		myWidth = width;
		myHeight = height;
		myViewModule = view;
		myParent = createParent();
	}
	
	public Module(double width, double height) throws Exception {
		this(width, height, null);
	}
	
	protected abstract Parent createParent() throws Exception;

	public ViewModule getViewModule() {
		return myViewModule;
	}
	
	public Parent getParent() {
		return myParent;
	}
	
	protected double getWidth() {
		return myWidth;
	}
	
	protected double getHeight() {
		return myHeight;
	}
	
	public abstract Element getXMLPreferences(Document doc);
}

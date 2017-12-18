package frontend.modules;

import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.scene.Parent;

/**
 * A class that allows the user to create a javafx parent within itself and be added in any order 
 * and any position to a controlling class
 * @author Albert
 *@author Lasia Lo
 */
public abstract class Module implements Observer{
	private double myWidth;
	private double myHeight;
	private Parent myParent;
	private ViewModule myViewModule;
	
	/**
	 * Creates a new Module
	 * @param width		width of module
	 * @param height	height of module
	 * @param view		associated ViewModule
	 * @throws Exception
	 */
	public Module(double width, double height, ViewModule view) throws Exception {
		myWidth = width;
		myHeight = height;
		myViewModule = view;
		myParent = createParent();
	}
	
	/**
	 * Creates a new Module without associated ViewModule
	 * @param width		width of module
	 * @param height	height of module
	 * @throws Exception
	 */
	public Module(double width, double height) throws Exception {
		this(width, height, null);
	}
	
	/**
	 * Set the associated ViewModule to a different ViewModule
	 * @param v	new ViewModule
	 */
	protected void setViewModule(ViewModule v) {
		myViewModule = v;
	}
	
	/**
	 * Creates the javafx parent that is associated with each module
	 * @return			associated javafx parent
	 * @throws Exception
	 */
	protected abstract Parent createParent() throws Exception;

	/**
	 * @return	associated ViewModule
	 */
	public ViewModule getViewModule() {
		return myViewModule;
	}
	
	/**
	 * @return	contained javafx parent
	 */
	public Parent getParent() {
		return myParent;
	}
	
	protected double getWidth() {
		return myWidth;
	}
	
	protected double getHeight() {
		return myHeight;
	}
	
	/**
	 * Creates an element to which the module writes its preferences
	 * @param doc	Document to write element to
	 * @return		Element written
	 */
	public abstract Element getXMLPreferences(Document doc);
	
	public void update(Observable obs, Object arg) {
		// do nothing as default
	}

	protected void setParent(Parent parent) {
		myParent = parent;
	}

}

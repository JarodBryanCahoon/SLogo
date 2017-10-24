package frontend.modules;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;

public abstract class Module {
	private double myWidth;
	private double myHeight;
	private Parent myParent;

	public Module(double width, double height) throws Exception {
		myWidth = width;
		myHeight = height;
		myParent = createParent();
	}
	
	protected abstract Parent createParent() throws Exception;
	
	public Parent getParent() {
		return myParent;
	}
	
	protected double getWidth() {
		return myWidth;
	}
	
	protected double getHeight() {
		return myHeight;
	}
}

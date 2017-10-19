package frontend.modules;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;

public abstract class Module {
	private int myWidth;
	private int myHeight;
	private Parent myParent;

	public Module(int width, int height, Parent parent /*, backend backend */) {
		myWidth = width;
		myHeight = height;
		myParent = parent;
	}
	
	protected void addChildren(List<Node> myNodes) {
		for(Node node : myNodes) {
			myParent.getChildrenUnmodifiable().add(node);
		}
	}
	
	public Parent getParent() {
		return myParent;
	}
	
	/* 
	 * public backend getBackend() {
	 * 	return backend
	 * }
	 */
}

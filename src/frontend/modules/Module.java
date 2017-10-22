package frontend.modules;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;

public abstract class Module {
	private int myWidth;
	private int myHeight;
	private Parent myParent;

	public Module(int width, int height) throws Exception {
		myWidth = width;
		myHeight = height;
		myParent = createParent(width,height);
	}
	
	protected abstract Parent createParent(int width, int height) throws Exception;
	
//	protected void addChildren(List<Node> myNodes) {
//		for(Node node : myNodes) {
//			myParent.getChildrenUnmodifiable().add(node);
//		}
//	}
	
	public Parent getParent() {
		return myParent;
	}
	
	/* 
	 * public backend getBackend() {
	 * 	return backend
	 * }
	 */
}

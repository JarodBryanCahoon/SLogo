package frontend.windows;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.Parent;

public abstract class Window {
	int myWidth;
	int myHeight;
	Parent myParent;
	public Window(int width, int height, Parent parent) {
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
}

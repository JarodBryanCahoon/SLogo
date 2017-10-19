package frontend.modules;

import java.util.List;
import java.util.Observer;

import javafx.scene.Group;
import javafx.scene.Parent;

public class RenderModule extends Module{
	
	private List<Observer> myObservers;
	public RenderModule(int width, int height) {
		super(width, height, new Group());
	}
	
	
}

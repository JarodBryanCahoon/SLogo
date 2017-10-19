package frontend.modules;

import java.util.List;
import java.util.Observer;

import frontend.observation.SpriteObserver;
import javafx.scene.Group;
import javafx.scene.Parent;

public class RenderModule extends Module{
	
	private List<SpriteObserver> myObservers;
	public RenderModule(int width, int height) {
		super(width, height);
	}
	
	@Override
	protected Parent createParent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

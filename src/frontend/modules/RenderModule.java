package frontend.modules;

import java.util.List;
import java.util.Observer;

import frontend.observation.SpriteObserver;
import javafx.scene.Group;
import javafx.scene.Parent;

public class RenderModule extends Module{
	
	private List<SpriteObserver> myObservers;
//	private List<Sprite> mySprite;
	public RenderModule(int width, int height) throws Exception {
		super(width, height);
		initializeSprite();
	}
	
	@Override
	protected Parent createParent() throws Exception {
		Group myGroup = new Group();
		return myGroup;
	}
	
	private void initializeSprite() {
		
	}
	
	public void clearScreen() {
		
	}
}

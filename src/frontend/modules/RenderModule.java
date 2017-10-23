package frontend.modules;

import java.util.List;
import java.util.Observer;

import backend.board.RenderSprite;
import frontend.observation.SpriteObserver;
import javafx.scene.Group;
import javafx.scene.Parent;

public class RenderModule extends Module{
	private List<RenderSprite> mySprites;
	private List<SpriteObserver> myObservers;

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

	public void updateRenderSprite(RenderSprite newSprite) {
		RenderSprite oldSprite = findSpriteById(newSprite);
		renderTransition(oldSprite, newSprite);
	}
	
	private RenderSprite findSpriteById(RenderSprite newSprite) {
		for(RenderSprite rSprite : mySprites) {
			if(rSprite.getId() == newSprite.getId()) {
				return rSprite;
			}
		}
		return null;
	}
	
	private void renderTransition(RenderSprite oldSprite, RenderSprite newSprite) {
		
	}
}

package frontend.observation;

import java.util.Observer;

import backend.board.ConcreteObject;
import backend.board.RenderSprite;

public abstract class SpriteObserver implements Observer{
	private ConcreteObject mySprite;
	public RenderSprite update() {
		return mySprite.getRenderSprite();
	}
}

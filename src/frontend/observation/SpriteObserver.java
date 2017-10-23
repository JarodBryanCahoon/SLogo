package frontend.observation;

import java.util.Observable;
import java.util.Observer;

import backend.board.ConcreteObject;
import backend.board.RenderSprite;
import frontend.modules.ViewModule;

public class SpriteObserver implements Observer{
	private ViewModule myView;
	public SpriteObserver(ViewModule view) {
		myView = view;
	}
	
	@Override
	public void update(Observable observable, Object obj) {
		if(obj instanceof RenderSprite) {
			myView.updateRenderSprite((RenderSprite) obj);
		}
	}
}

package backend.board;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RenderSpriteCollection extends Observable implements iRenderSprite, Observer {
	private List<RenderSprite> mySprites;
	public RenderSpriteCollection(List<RenderSprite> sprites) {
		
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPenDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getAngle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RenderMath getMath() {
		// TODO Auto-generated method stub
		return null;
	}
}

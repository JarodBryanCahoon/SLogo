package frontend.sprites;

import java.util.Observer;

import javafx.scene.image.Image;

public abstract class Sprite {
	private int myX;
	private int myY;
	private Observer myObserver;
	private RenderSprite myRenderSprite;
	private Image myImage;
	
	public Sprite(int X, int Y, String imagePath) {
		myX = X;
		myY = Y;
		myRenderSprite = new RenderSprite(X, Y, imagePath);
	}
	
	public void setObserver(Observer obs) {
		myObserver = obs;
	}
	
	public RenderSprite getRenderSprite() {
		return myRenderSprite;
	}
}

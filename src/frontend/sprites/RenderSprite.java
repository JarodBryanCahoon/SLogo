package frontend.sprites;

import javafx.scene.image.Image;

public class RenderSprite implements iRenderSprite {
	private int myX;
	private int myY;
	private Image myImage;
	private boolean penUp = false;
	private boolean isVisible = true;	
	
	public RenderSprite(int X, int Y, String imagePath) {
		myX = X;
		myY = Y;
		myImage = new Image(imagePath);
	}
	
	public void penUp() {
		penUp = true;
	}
	
	public void penDown() {
		penUp = false;
	}
	
	public boolean isPenUp() {
		return penUp;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public int getX() {
		return myX;
	}
	
	public int getY() {
		return myY;
	}
}

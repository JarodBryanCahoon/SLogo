package backend.board;

import javafx.scene.image.Image;

public class RenderSprite implements iRenderSprite {
	private double myX;
	private double myY;
	private Image myImage;
	private boolean penDown;
	private boolean isVisible;	
	
	public RenderSprite(double X, double Y, String imagePath) {
		myX = X;
		myY = Y;
		myImage = new Image(imagePath);
	}
	
	public RenderSprite(GeneralObject sprite) {
		
	}
	
	public boolean isPenDown() {
		return penDown;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public double getX() {
		return myX;
	}
	
	public double getY() {
		return myY;
	}

}

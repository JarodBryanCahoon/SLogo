package backend.board;

import javafx.scene.image.Image;

public class RenderSprite implements iRenderSprite {
	private double myX;
	private double myY;
	private Image myImage;
	private boolean penDown;
	private boolean isVisible;	
	private double myAngle;
	private int myTurtleId;
	
	public RenderSprite(double X, double Y, double angle, String imagePath, int id) {
		myX = X;
		myY = Y;
		myAngle = angle;
		myTurtleId = id;
		myImage = new Image(imagePath);
	}
	
	public RenderSprite(GeneralObject sprite) {
		
	}
	
	public double isPenDown() {
		return penDown? 1:0;
	}
	
	public double isVisible() {
		return isVisible? 1:0;
	}
	
	public double getX() {
		return myX;
	}
	
	public double getY() {
		return myY;
	}

	public int getId() {
		return myTurtleId;
	}
}

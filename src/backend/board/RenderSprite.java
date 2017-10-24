package backend.board;

import java.util.Observer;
import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RenderSprite extends Observable implements iRenderSprite, Observer {
	private double myX;
	private double myY;
	private ImageView myImageView;
	private boolean penDown;
	private int myPenWidth;
	private boolean isVisible;	
	private double myAngle;
	private int myTurtleId;
	private ConcreteObject myObserved;
	
	public RenderSprite(ConcreteObject sprite, String imagePath) {
		myObserved = sprite;
		myX = myObserved.getX();
		myY = myObserved.getY();
		myAngle = myObserved.getAngle();
		myTurtleId = myObserved.getId();
		myImageView = new ImageView(getClass().getClassLoader().getResource(imagePath).getPath());
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
	
	public ImageView getImage() {
		return myImageView;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getAngle() {
		return myAngle;
	}
}

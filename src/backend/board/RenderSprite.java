package backend.board;

import java.util.Observer;
import java.util.Observable;

import javafx.beans.value.ObservableValue;
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
	private boolean myOpacity;
	
	public RenderSprite(ConcreteObject sprite, String imagePath) {
		myX = Turtle.STARTING_POSITION[0];
		myY = Turtle.STARTING_POSITION[1];
		myAngle = Turtle.STARTING_ANGLE;
		penDown = true;
		myTurtleId = sprite.getId();
		myOpacity = true;
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
	
	public boolean getOpacity() {
		return myOpacity;
	}
	
	public ImageView getImage() {
		return myImageView;
	}

	@Override
	public double getAngle() {
		return myAngle;
	}
	
	protected void changeX(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myX = newVal.doubleValue();
	}
	
	protected void changeY(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myY = newVal.doubleValue();
	}

	protected void changeAngle(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myAngle = newVal.doubleValue();
	}

	protected void changeId(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myTurtleId = newVal.intValue();
	}

	protected void changePen(ObservableValue<? extends Boolean> obs, Boolean oldVal, Boolean newVal) {
		penDown = newVal.booleanValue();
	}

	protected void changeOpacity(ObservableValue<? extends Boolean> obs, Boolean oldVal, Boolean newVal) {
		myOpacity = newVal.booleanValue();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}

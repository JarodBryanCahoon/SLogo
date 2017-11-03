package backend.board;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import backend.board.interfacemovement.TurtleNode;

/**
 * A Class that handles the backend part of executing turtle commands
 * @author Albert
 * @author Jarod Cahoon
 *
 */
public class Turtle extends Observable implements ITurtle, Observer {
	public static final double STARTING_ANGLE = 90;
	public static final double[] STARTING_POSITION = { 0, 0 };
	private int myTurtleId;
	private RenderMath myRenderMath;

	private double myXPos;
	private double myYPos;
	private double myAngle;
	private boolean myPenDown;
	private boolean myOpacity;
	private boolean isSelected;
	private boolean clearScreen = false;

	/**
	 * Create a new Turtle
	 * @param ob	the RenderSprite that is observing this turtle
	 */
	public Turtle(RenderSprite ob) {
		addObserver(ob);
		readRenderSprite(ob);
	}

	@Override
	public double act(TurtleNode m) throws IOException {
		double returnValue = m.act(this);
		setChanged();
		this.notifyObservers(this);
		return returnValue;
	}

	/**
	 * @return the id of the turtle
	 */
	public int getId() {
		return myTurtleId;
	}
	
	/**
	 * Changes turtle isSelected value to param
	 * @param selected	whether or not the turtle should be selected
	 */
	public void selectTurtle(boolean selected) {
		isSelected = selected;
	}

	/**
	 * @return	the slogo x position of the turtle
	 */
	public double getMyX() {
		return this.myXPos;
	}

	/**
	 * @return	the slogo y position of the turtle
	 */
	public double getMyY() {
		return this.myYPos;
	}

	/**
	 * @return	the slogo angle of the turtle
	 */
	public double getAngle() {
		return this.myAngle;
	}

	/**
	 * @return	whether or not the pen is down
	 */
	public boolean getPen() {
		return myPenDown;
	}

	/**
	 * @return	whether or not the turtle is visible
	 */
	public boolean getOpacity() {
		return myOpacity;
	}

	/**
	 * @return	whether or not the turtle is selected
	 */
	public boolean isSelected() {
		return isSelected;
	}
	
	/**
	 * sets the clear screen instance field in the turtle
	 * @param clear	whether or not the turtle should clear the screen
	 */
	public void setClearScreen(boolean clear) {
		clearScreen = clear;
	}
	
	/**
	 * @return	whether or not the turtle wants to clear the screen
	 */
	public boolean getClearScreen() {
		return clearScreen;
	}

	/**
	 * set the value of the turtle's instance fields to the values of the rendersprite's
	 * @param ob	RenderSprite to read state from
	 */
	private void readRenderSprite(RenderSprite ob) {
		myXPos = ob.getX();
		myYPos = ob.getY();
		myAngle = ob.getAngle();
		myPenDown = ob.isPenDown();
		myOpacity = ob.isVisible();
		isSelected = ob.isSelected();
		myTurtleId = ob.getId();
		myRenderMath = ob.getMath();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		RenderSprite rs = (RenderSprite) arg0;
		readRenderSprite(rs);
	}

	@Override
	public void setX(double X) {
		myXPos = myRenderMath.xTranslate(X);
	}

	@Override
	public void setY(double Y) {
		myYPos = myRenderMath.yTranslate(Y);
	}

	@Override
	public void setAngle(double angle) {
		myAngle = angle;
	}

	@Override
	public void setPen(boolean penDown) {
		myPenDown = penDown;
	}

	@Override
	public void setOpacity(boolean isVisible) {
		myOpacity = isVisible;
	}
}

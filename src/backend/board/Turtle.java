package backend.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import backend.board.interfacemovement.ActionInterface;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Point2D;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends Observable{
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private DoubleProperty myXPos;
		private DoubleProperty myYPos;
		private DoubleProperty myAngle;
		private BooleanProperty myPenDown;
		private BooleanProperty myOpacity;
		private IntegerProperty myTurtleId;

		// https://stackoverflow.com/questions/23335522/how-do-i-write-a-new-listchangelisteneritem-with-lambda
		public Turtle(String imagePath, int id, RenderSprite ob) {
			addObserver(ob);
			myXPos.set(ob.getX());
			myYPos.set(ob.getY());
			myAngle.set(ob.getAngle());
			myTurtleId.set(ob.getId());
			myPenDown.set(ob.isPenDown());
			myOpacity.set(ob.isVisible());
		}
		
		public double Act(ActionInterface m){
			double returnValue = m.act(this);
			setChanged();
			this.notifyObservers(this);
			return returnValue;
		}
		
		public int getId() {
			return myTurtleId.get();
		}
		
		public DoubleProperty getMyX() {
			return this.myXPos;
		}
		
		public DoubleProperty getMyY() {
			return this.myYPos;
		}
		
		public DoubleProperty getAngle() {
			return this.myAngle;
		}
		
		public BooleanProperty getPen() {
			return myPenDown;
		}
		
		public BooleanProperty getOpacity() {
			return myOpacity;
		}
		
		public IntegerProperty getID() {
			return myTurtleId;
		}
}

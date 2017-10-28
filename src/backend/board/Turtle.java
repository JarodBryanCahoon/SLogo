package backend.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.board.interfacemovement.Node;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Point2D;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends Observable implements Observer{
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private DoubleProperty myXPos;
		private DoubleProperty myYPos;
		private DoubleProperty myAngle;
		private BooleanProperty myPenDown;
		private BooleanProperty myOpacity;
		private IntegerProperty myTurtleId;
		private RenderMath myRenderMath;

		public Turtle(String imagePath, int id, RenderSprite ob, RenderMath math) {
			addObserver(ob);
			readRenderSprite(ob);
			myRenderMath = math;
		}
		
		public double Act(Node m){
			double returnValue = m.act(this);
			setChanged();
			this.notifyObservers(this);
			return returnValue;
		}
		
		public RenderMath getMath() {
			return myRenderMath;
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
		
		private void readRenderSprite(RenderSprite ob) {
			myXPos.set(ob.getX());
			myYPos.set(ob.getY());
			myAngle.set(ob.getAngle());
			myTurtleId.set(ob.getId());
			myPenDown.set(ob.isPenDown());
			myOpacity.set(ob.isVisible());
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			RenderSprite rs = (RenderSprite) arg0;
			readRenderSprite(rs);
		}
}

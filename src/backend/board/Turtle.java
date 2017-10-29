package backend.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.interfacemovement.TurtleNode;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Point2D;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends Observable implements ITurtle, Observer{
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private DoubleProperty myXPos;
		private DoubleProperty myYPos;
		private DoubleProperty myAngle;
		private BooleanProperty myPenDown;
		private BooleanProperty myOpacity;
		private int myTurtleId;
		private RenderMath myRenderMath;
		private BooleanProperty isSelected;
		

		public Turtle(RenderSprite ob) {
			addObserver(ob);
			readRenderSprite(ob);
		}
		
		public double act(TurtleNode m){
			double returnValue = m.act(this);
			setChanged();
			this.notifyObservers(this);
			return returnValue;
		}
		
		public RenderMath getMath() {
			return myRenderMath;
		}
		
		public int getId() {
			return myTurtleId;
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
		
		public int getID() {
			return myTurtleId;
		}
		
		public boolean isSelected() {
			return isSelected.get();
		}
		
		private void readRenderSprite(RenderSprite ob) {
			myXPos.set(ob.getX());
			myYPos.set(ob.getY());
			myAngle.set(ob.getAngle());
			myPenDown.set(ob.isPenDown());
			myOpacity.set(ob.isVisible());
			isSelected.set(ob.isSelected());
			myTurtleId = ob.getId();
			myRenderMath = ob.getMath();
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			RenderSprite rs = (RenderSprite) arg0;
			readRenderSprite(rs);
		}
}

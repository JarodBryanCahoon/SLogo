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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends Observable implements ITurtle, Observer{
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private int myTurtleId;		
		private RenderMath myRenderMath;

		private double myXPos;
		private double myYPos;
		private double myAngle;
		private boolean myPenDown;
		private boolean myOpacity;
		private boolean isSelected;

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
		
		public double getMyX() {
			return this.myXPos;
		}
		
		public double getMyY() {
			return this.myYPos;
		}
		
		public double getAngle() {
			return this.myAngle;
		}
		
		public boolean getPen() {
			return myPenDown;
		}
		
		public boolean getOpacity() {
			return myOpacity;
		}
		
		public int getID() {
			return myTurtleId;
		}
		
		public boolean isSelected() {
			return isSelected;
		}
		
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

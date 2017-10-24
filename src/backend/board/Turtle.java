package backend.board;

import java.util.ArrayList;
import java.util.List;

import backend.Utilities.vectors.Vector;
import backend.Utilities.vectors.VectorMath;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends ConcreteObject {
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private String myImagePath;
		private DoubleProperty myXPos;
		private DoubleProperty myYPos;
		private DoubleProperty myAngle;
		private BooleanProperty myPenDown;
		private BooleanProperty myOpacity;
		private IntegerProperty myTurtleId;
		private RenderSprite myObserver;

		// https://stackoverflow.com/questions/23335522/how-do-i-write-a-new-listchangelisteneritem-with-lambda
		public Turtle(String imagePath, int id, RenderSprite ob) {
			myObserver = ob;
			myXPos.set(STARTING_POSITION[0]);
			myYPos.set(STARTING_POSITION[1]);
			myAngle.set(STARTING_ANGLE);
			myTurtleId.set(id);
			myPenDown.set(true);
			myOpacity.set(true);

			myXPos.addListener( (obs, oldVal, newVal) -> myObserver.changeX(obs, oldVal, newVal));
			myYPos.addListener( (obs, oldVal, newVal) -> myObserver.changeY(obs, oldVal, newVal));
			myAngle.addListener( (obs, oldVal, newVal) -> myObserver.changeAngle(obs, oldVal, newVal) );
			myTurtleId.addListener((obs, oldVal, newVal) -> myObserver.changeId(obs, oldVal, newVal) );
			myPenDown.addListener((obs, oldVal, newVal) -> myObserver.changePen(obs, oldVal, newVal) );
			myOpacity.addListener((obs, oldVal, newVal) -> myObserver.changeOpacity(obs, oldVal, newVal) );
		}
		
		public double moveForward(double pixels) {
			move(true, pixels);
			return pixels;
		}
		
		public double moveBackwards(double pixels) {
			move(false, pixels);
			return pixels;
		}
		
		public double turnLeft(double addAngle) {
			myAngle.set((myAngle.get()+addAngle)%360);
			return addAngle;
		}
	
		public double turnRight(double addAngle) {
			int modulo = (int) Math.abs(addAngle / 360 + 1);			
			double holder = 360 - addAngle;
			holder += ( 360 * modulo ) % 360;
			myAngle.set(holder);
			return addAngle;
		}
	
		public double setAngle(double angle) {
			double returnAngle = angleDifference(angle);
			myAngle.set(angle);
			return returnAngle;
		}

		private double angleDifference(double angle) {
			return (Math.abs(angle-myAngle.get()) > 180) ? Math.abs(angle-myAngle.get())-180 : Math.abs(angle-myAngle.get());
		}
		
		public double setTowards(double x, double y) {
			double newAngle = VectorMath.angleBetweenXAxis(new Vector(x,y));
			double angleDiff = angleDifference(newAngle);
			myAngle.set(newAngle);
			return angleDiff;
			
		}
	
		public double setHome() {
			double distance = BoardMath.pointDistance(0, 0, myXPos.get(), myYPos.get());
			myXPos.set(0);
			myYPos.set(0);
			return distance;
		}
	
		public double hide() {
			myOpacity.set(false);
			return 0;
		}
	
		public double show() {
			myOpacity.set(true);
			return 1;
		}
		
		@Override
		public double setPostion(double x, double y) {
			double diff = BoardMath.pointDistance(x, y, myXPos.get(), myYPos.get());
			myXPos.set(x);
			myYPos.set(y);
			return diff;
		}
		
		private void move(boolean b,double pixels){
			double[] delta = BoardMath.xyDeltaCalc(pixels, myAngle.get());
			double xHold = myXPos.get();
			double yHold = myYPos.get();
			xHold += b? delta[0]: -delta[0];
			yHold += b? delta[1]: -delta[1];
			myXPos.set(xHold);
			myYPos.set(yHold);
		}

		public double penDown() {
			myPenDown.set(true);
			return 1;
		}
		
		public double penUp() {
			myPenDown.set(false);
			return 0;
		}
		
		public void undo(RenderSprite rs) {
			myPenDown.set(false);
			myXPos.set(rs.getX());
			myYPos.set(rs.getY());
			myAngle.set(rs.getAngle());
			myOpacity.set(rs.isVisible()==1);
			myPenDown.set(rs.isPenDown()==1);
		}
		
		@Override
		public RenderSprite getRenderSprite() {
			return new RenderSprite(this, myImagePath);
		}
		
		@Override
		public void notifyObservers() {
//			for(RenderSprite obs : myObservers) {
//				obs.update(this, 0);
//			}
		}

		@Override
		public int getId() {
			return myTurtleId.get();
		}

}

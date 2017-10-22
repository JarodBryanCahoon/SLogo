package backend.board;

import java.util.List;

import backend.Utilities.vectors.Vector;
import backend.Utilities.vectors.VectorMath;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends ConcreteObject{
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private String myImage;
		private double myXPos;
		private double myYPos;
		private double myAngle;
		private boolean myPenDown;
		private boolean myOpacity;
		private int myTurtleId;

		public Turtle(String imagePath, int id) {
			myXPos = STARTING_POSITION[0];
			myYPos = STARTING_POSITION[1];
			myAngle = STARTING_ANGLE; 
			myTurtleId = id;
			myPenDown = true;
			myOpacity = true;
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
			myAngle = (myAngle+addAngle)%360;
			return addAngle;
		}
	
		public double turnRight(double addAngle) {
			int modulo = (int) Math.abs(addAngle / 360 + 1);			
			myAngle = 360 - addAngle;
			myAngle = ( 360 * modulo ) % 360;
			return addAngle;
		}
	
		public double setAngle(double angle) {
			double returnAngle = angleDifference(angle);
			myAngle = angle;
			return returnAngle;
		}

		private double angleDifference(double angle) {
			return (Math.abs(angle-myAngle) > 180) ? Math.abs(angle-myAngle)-180 : Math.abs(angle-myAngle);
		}
		
		public double setTowards(double x, double y) {
			double newAngle = VectorMath.angleBetweenXAxis(new Vector(x,y));
			double angleDiff = angleDifference(newAngle);
			myAngle = newAngle;
			return angleDiff;
			
		}
	
		public double setHome() {
			double distance = BoardMath.pointDistance(0, 0, myXPos, myYPos);
			myXPos = myYPos = 0;
			return distance;
		}
	
		public double hide() {
			myOpacity = false;
			return 0;
		}
	
		public double show() {
			myOpacity = true;
			return 1;
		}
		
		@Override
		public double setPostion(double x, double y) {
			double diff = BoardMath.pointDistance(x, y, myXPos, myYPos);
			myXPos = x;
			myYPos = y;
			return diff;
		}
		
		private void move(boolean b,double pixels){
			double[] delta = BoardMath.xyDeltaCalc(pixels, myAngle);
			myXPos += b? delta[0]: -delta[0];
			myYPos += b? delta[1]: -delta[1];
		}

		@Override
		public double getX() {
			return myXPos;
		}

		@Override
		public double getY() {
			return myYPos;
		}



		@Override
		public double isVisible() {
			return myOpacity? 1:0;
		}
		
		public double getXCor() {
			return myXPos;
		}
		
		public double getYCor() {
			return myYPos;
		}
		
		public double myHeading() {
			return myAngle;
		}
		
		public double isPenDown() {
			return myPenDown ? 1:0;
		}
		public void undo(RenderSprite rs) {
			myPenDown = false;
			myXPos = rs.getX();
			myYPos = rs.getY();
			myOpacity = rs.isVisible()==1;
			myPenDown = rs.isPenDown()==1;
		}

		@Override
		public RenderSprite getRenderSprite() {
			return new RenderSprite(myXPos, myYPos, myAngle, myImage);
		}

}

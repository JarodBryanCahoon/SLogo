package backend.board;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends ConcreteObject{
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private double myXPos;
		private double myYPos;
		private double myAngle;
		private boolean myPenDown;
		private boolean myOpacity;

		public Turtle() {
			myXPos = STARTING_POSITION[0];
			myYPos = STARTING_POSITION[1];
			myAngle = STARTING_ANGLE; 
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
			if(myAngle - addAngle <= 0)
				myAngle = 360 - (addAngle - myAngle);
			else
				myAngle -= addAngle;
			return addAngle;
		}
	
		public double setAngle(double angle) {
			myAngle = angle;
			return 0;
		}
	
		public double setHome() {
			double distance = BoardMath.pointDistance(0, 0, myXPos, myYPos);
			myXPos = myYPos = 0;
			return distance;
		}
	
		public double Hide() {
			myOpacity = false;
			return 0;
		}
	
		public double Show() {
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
			myYPos += b? delta[1]: -delta[0];
		}

}

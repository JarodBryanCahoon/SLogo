package board;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle implements ObjectInterface{
		private double myXPos;
		private double myYPos;
		private double myAngle;
		private boolean myPenDown;
		private boolean myOpacity;

		public Turtle() {
			myYPos = myXPos = 0;
			myAngle = 90; 
			myPenDown = true;
			myOpacity = true;
		}
		
		public double moveForward(double pixels) {
			// TODO Auto-generated method stub
			return pixels;
		}
		
		public double moveBackwards(double pixels) {
			// TODO Auto-generated method stub
			return pixels;
		}
		
		public double turnLeft() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public double turnRight() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public double setAngle() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public double setHome() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public double clearScreen() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public double Hide() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public double Show() {
				
			return 0;
		}

		public double setPostion(double x, double y) {

			return 0;
		}

		@Override
		public double moveForward() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double moveBackwards() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double setPostion() {
			// TODO Auto-generated method stub
			return 0;
		}
		
}

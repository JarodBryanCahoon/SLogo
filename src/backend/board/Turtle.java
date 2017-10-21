package backend.board;

import java.util.List;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends ConcreteObject{
		private double myXPos;
		private double myYPos;
		private double myAngle;
		private boolean myPenDown;
		private boolean myOpacity;
		private RenderSprite myRenderSprite;
		private List<RenderSprite> prevRenderSprites;

		public Turtle(String imagePath) {
			myYPos = myXPos = 0;
			myAngle = 90; 
			myPenDown = true;
			myOpacity = true;
			myRenderSprite = new RenderSprite(myXPos, myYPos, imagePath);
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
	
		public double setAngle() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public double setHome() {
			// TODO Auto-generated method stub
			return 0;
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
			double diff = TurtleMath.pointDistance(x, y, myXPos, myYPos);
			myXPos = x;
			myYPos = y;
			return diff;
		}
		
		private void move(boolean b,double pixels){
			double[] delta = TurtleMath.xyDeltaCalc(pixels, myAngle);
			myXPos += b? delta[0]: -delta[0];
			myYPos += b? delta[1]: -delta[0];
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
		public boolean isPenDown() {
			return this.myPenDown;
		}

		@Override
		public boolean isVisible() {
			// TODO Auto-generated method stub
			return false;
		}

}

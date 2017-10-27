package backend.board;

/**
 * 
 * @author Jarod Cahoon
 * This class is for static methods which help calculate certain properties for the Turtle class
 */
public class BoardMath {
	public static double[] xyDeltaCalc(double pixels, double d) {
		double[] arr = {pixels*Math.cos(toDegrees(d)), pixels*Math.sin(toDegrees(d))};
		return arr;
	}
	
	public static double toDegrees(double a) {
		return a*Math.PI/180;
	}
	
	public static double pointDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1), 2));
	}
}

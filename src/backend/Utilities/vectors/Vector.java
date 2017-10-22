package backend.Utilities.vectors;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Vector {
	private double myXComp;
	private double myYComp;
	
	public Vector(double x, double y) {
		myXComp = x;
		myYComp = y;
	}
	
	public double getXComp() {
		return myXComp;
	}
	
	public double getYComp() {
		return myYComp;
	}
	
	public void unitize() {
		double distance = Math.sqrt(Math.pow(myXComp, 2) + Math.pow(myYComp, 2));
		myXComp /= distance;
		myYComp /= distance;
	}
	
}

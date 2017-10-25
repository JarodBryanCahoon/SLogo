package backend.board.interfacemovement;

import backend.Utilities.vectors.Vector;
import backend.Utilities.vectors.VectorMath;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetTowards extends AbsoluteMovement{
	private double myX;
	private double myY;
	
	public SetTowards(double x, double y) {
		myX = x;
		myY = y;
	}
	
	public double act(Turtle co) {
		double newAngle = VectorMath.angleBetweenXAxis(new Vector(myX,myY));
		double angleDiff = angleDifference(newAngle, co.getAngle().get());
		co.getAngle().set(newAngle);
		return angleDiff;
	}

}

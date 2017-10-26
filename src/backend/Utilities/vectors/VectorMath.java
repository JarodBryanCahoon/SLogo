package backend.Utilities.vectors;
import backend.board.BoardMath;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class VectorMath {
	public static final Vector X_AXIS = new Vector(1,0);
	public static final Double X_VEC_MAG = 1.0;
	public static final Vector ZERO_VECTOR = new Vector(0,0);
	
	public static double angleBetweenXAxis(Vector v1) {
		return Math.toDegrees(Math.acos(VectorMath.dotProduct(v1, X_AXIS)/(VectorMath.vecMagnitude(v1)*1.0)));
		
	}
	
	public static double dotProduct(Vector v1, Vector v2) {
		return v1.getXComp()*v2.getXComp() + v1.getYComp()+v2.getYComp();
	}
	
	public static double vecMagnitude(Vector v1) {
		return BoardMath.pointDistance(ZERO_VECTOR.getXComp(), ZERO_VECTOR.getYComp(), v1.getXComp(), v1.getYComp());
	}
}

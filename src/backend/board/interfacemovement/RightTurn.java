package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class RightTurn implements MoveInterface {
	double myAngle;
	
	public RightTurn(double ang) {
		myAngle = ang;
	}
	@Override
	public double act(Turtle co) {
		int modulo = (int) Math.abs(myAngle / 360 + 1);			
		double holder = 360 - myAngle;
		holder += ( 360 * modulo ) % 360;
		co.getAngle().set(holder);
		return myAngle;
	}
	
}

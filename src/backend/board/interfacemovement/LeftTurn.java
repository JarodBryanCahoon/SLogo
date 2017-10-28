package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class LeftTurn implements ActionInterface{
	double myAngle;
	
	public LeftTurn(double ang) {
		myAngle = ang;
	}
	@Override
	public double act(Turtle co) {
		co.getAngle().set((co.getAngle().get()+myAngle)%360);
		return myAngle;
	}
	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}

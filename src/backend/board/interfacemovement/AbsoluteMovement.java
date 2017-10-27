package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class AbsoluteMovement implements ActionInterface{

	
	protected double angleDifference(double angle1, double angle2) {
		return (Math.abs(angle1-angle2) > 180) ? Math.abs(angle1-angle2)-180 : Math.abs(angle1-angle2);
	}
	
	@Override
	public double act(Turtle co) {
		// TODO Auto-generated method stub
		return 0;
	}

}

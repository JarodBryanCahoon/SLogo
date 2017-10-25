package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class ForwardLineMovement extends LineMovement {
	double myDistance;
	
	public ForwardLineMovement(double b) {
		myDistance =  b;
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, myDistance, co);
	}
	
}

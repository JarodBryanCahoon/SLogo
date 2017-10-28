package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenDown implements ActionInterface{
	
	public PenDown() {
		
	}

	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 1;
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}

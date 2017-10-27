package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenUp implements ActionInterface{
	
	public PenUp() {
		
	}

	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 0;
	}

}

package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Hide implements ActionInterface{

	public Hide() {
		
	}
	
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(false);
		return 0;
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

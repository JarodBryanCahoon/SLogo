package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Show implements ActionInterface{

	public Show() {
		
	}
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(true);
		return 1;
	}
	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
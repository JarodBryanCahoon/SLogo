package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Show implements MoveInterface{

	public Show() {
		
	}
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(true);
		return 1;
	}
	

}
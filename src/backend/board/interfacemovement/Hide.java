package backend.board.interfacemovement;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Hide implements MoveInterface{

	public Hide() {
		
	}
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(false);
		return 0;
	}
	

}
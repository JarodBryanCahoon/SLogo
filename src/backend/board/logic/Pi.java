package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Pi implements ActionInterface{
	
	public Pi() {
	}
	
	public double act(Turtle tu) {
		return Math.PI;
	}
}
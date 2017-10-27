package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Pi implements InactiveInterface{
	
	public Pi() {
	}
	
	public double act() {
		return Math.PI;
	}
}
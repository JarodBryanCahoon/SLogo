package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.Node;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Minus implements InactiveInterface{
	double myNumOne;
	
	public Minus(double a) {
		myNumOne = a;
	}
	
	public double act() {
		return -myNumOne;
	}
}
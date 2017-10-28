package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.Node;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class And implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public And(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return (myNumOne != 0 && myNumTwo != 0) ? 1:0;
	}
}
package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Difference implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Difference(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return myNumOne-myNumTwo;
	}
}
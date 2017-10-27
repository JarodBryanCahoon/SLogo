package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Quotient implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Quotient(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return myNumOne*myNumTwo;
	}
}
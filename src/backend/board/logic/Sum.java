package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.Node;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Sum implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Sum(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return myNumOne+myNumTwo;
	}
}

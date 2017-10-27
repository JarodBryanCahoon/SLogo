package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class NotEqual implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public NotEqual(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return (myNumOne != myNumTwo) ? 1:0;
	}
}
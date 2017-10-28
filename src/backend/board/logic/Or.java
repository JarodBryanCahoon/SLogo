package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Or implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Or(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return (myNumOne != 0 || myNumTwo != 0) ? 1:0;
	}
}
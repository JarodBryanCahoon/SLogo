package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Pow implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Pow(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return Math.pow(myNumOne, myNumTwo);
	}
}
package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class IsGreater implements ActionInterface{
	double myNumOne;
	double myNumTwo;
	
	public IsGreater(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act(Turtle tu) {
		return (myNumOne>myNumTwo) ? 1:0;
	}
}
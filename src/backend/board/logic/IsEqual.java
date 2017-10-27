package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class IsEqual implements ActionInterface{
	double myNumOne;
	double myNumTwo;
	
	public IsEqual(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act(Turtle tu) {
		return (myNumOne==myNumTwo) ? 1:0;
	}
}
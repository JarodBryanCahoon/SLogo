package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Pow implements ActionInterface{
	double myNumOne;
	double myNumTwo;
	
	public Pow(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act(Turtle tu) {
		return Math.pow(myNumOne, myNumTwo);
	}
}
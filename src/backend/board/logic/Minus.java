package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Minus implements ActionInterface{
	double myNumOne;
	
	public Minus(double a) {
		myNumOne = a;
	}
	
	public double act(Turtle tu) {
		return -myNumOne;
	}
}
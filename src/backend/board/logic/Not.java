package backend.board.logic;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Not implements ActionInterface{
	double myNumOne;
	
	public Not(double a, double b) {
		myNumOne = a;
	}
	
	public double act(Turtle tu) {
		return (myNumOne == 0) ? 1:0;
	}
}

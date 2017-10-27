package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Tan implements ActionInterface{
	double myNumOne;
	
	public Tan(double a) {
		myNumOne = a;
	}
	
	public double act(Turtle tu) {
		 return Math.tan(Math.toDegrees(myNumOne));
	}
}
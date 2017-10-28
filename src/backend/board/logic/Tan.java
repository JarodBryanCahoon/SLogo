package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Tan implements InactiveInterface{
	double myNumOne;
	
	public Tan(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return Math.tan(Math.toDegrees(myNumOne));
	}
}
package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Cos implements InactiveInterface{
	double myNumOne;
	
	public Cos(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return Math.cos(Math.toDegrees(myNumOne));
	}
}
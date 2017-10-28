package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Random implements InactiveInterface{
	double myNumOne;
	
	public Random(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return ThreadLocalRandom.current().nextDouble(0, myNumOne + 1);
	}
}
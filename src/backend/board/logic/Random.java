package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Random implements ActionInterface{
	double myNumOne;
	
	public Random(double a) {
		myNumOne = a;
	}
	
	public double act(Turtle tu) {
		 return ThreadLocalRandom.current().nextDouble(0, myNumOne + 1);
	}
}
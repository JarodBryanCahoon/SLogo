package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Cos implements ActionInterface{
	double myNumOne;
	
	public Cos(double a) {
		myNumOne = a;
	}
	
	public double act(Turtle tu) {
		 return Math.cos(Math.toDegrees(myNumOne));
	}
}
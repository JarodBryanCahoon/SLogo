package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Atan implements ActionInterface{
	double myNumOne;
	
	public Atan(double a) {
		myNumOne = a;
	}
	
	public double act(Turtle tu) {
		 return Math.atan(Math.toDegrees(myNumOne));
	}
}
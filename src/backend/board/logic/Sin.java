package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.board.Turtle;
import backend.board.interfacemovement.ActionInterface;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Sin implements ActionInterface{
	double myNumOne;
	
	public Sin(double a) {
		myNumOne = a;
	}
	
	public double act(Turtle tu) {
		 return Math.sin(Math.toDegrees(myNumOne));
	}
}
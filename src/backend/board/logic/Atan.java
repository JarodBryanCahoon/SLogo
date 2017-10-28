package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Atan implements InactiveInterface{
	double myNumOne;
	
	public Atan(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return Math.atan(Math.toDegrees(myNumOne));
	}
}
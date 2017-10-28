package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Sin implements InactiveInterface{
	double myNumOne;
	
	public Sin(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return Math.sin(Math.toDegrees(myNumOne));
	}
}
package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
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
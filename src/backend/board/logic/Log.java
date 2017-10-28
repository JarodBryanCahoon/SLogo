package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Log implements InactiveInterface{
	double myNumOne;
	
	public Log(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return Math.log(myNumOne);
	}
}
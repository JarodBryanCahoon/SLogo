package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Minus implements InactiveInterface{
	double myNumOne;
	
	public Minus(double a) {
		myNumOne = a;
	}
	
	public double act() {
		return -myNumOne;
	}
}
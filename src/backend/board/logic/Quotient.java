package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Quotient implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Quotient(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return myNumOne*myNumTwo;
	}
}
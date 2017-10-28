package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Remainder implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public Remainder(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return myNumOne%myNumTwo;
	}
}
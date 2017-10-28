package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class IsLess implements InactiveInterface{
	double myNumOne;
	double myNumTwo;
	
	public IsLess(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return (myNumOne<myNumTwo) ? 1:0;
	}
}
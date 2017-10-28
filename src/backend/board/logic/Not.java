package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Not implements InactiveInterface{
	double myNumOne;
	
	public Not(double a, double b) {
		myNumOne = a;
	}
	
	public double act() {
		return (myNumOne == 0) ? 1:0;
	}
}

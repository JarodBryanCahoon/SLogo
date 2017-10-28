package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class And implements ASTNode{
	double myNumOne;
	double myNumTwo;
	
	public And(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	@Override
	public double execute() {
		return (myNumOne != 0 && myNumTwo != 0) ? 1:0;
	}

	@Override
	public void setChildren(ASTNode n) {
		// TODO Auto-generated method stub
		
	}
}
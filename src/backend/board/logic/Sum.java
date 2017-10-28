package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Sum implements ASTNode{
	double myNumOne;
	double myNumTwo;
	
	public Sum(double a, double b) {
		myNumOne = a;
		myNumTwo = b;
	}
	
	public double act() {
		return myNumOne+myNumTwo;
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setChildren(ASTNode n) {
		// TODO Auto-generated method stub
		
	}
}

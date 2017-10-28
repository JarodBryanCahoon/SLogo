package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Minus implements ASTNode{
	double myNumOne;
	
	public Minus(double a) {
		myNumOne = a;
	}
	
	public double act() {
		return -myNumOne;
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
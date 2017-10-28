package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Not implements ASTNode{
	double myNumOne;
	
	public Not(double a, double b) {
		myNumOne = a;
	}
	
	public double act() {
		return (myNumOne == 0) ? 1:0;
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

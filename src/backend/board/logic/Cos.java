package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Cos implements ASTNode{
	double myNumOne;
	
	public Cos(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return Math.cos(Math.toDegrees(myNumOne));
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
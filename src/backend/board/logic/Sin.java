package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Sin implements ASTNode{
	double myNumOne;
	
	public Sin(double a) {
		myNumOne = a;
	}
	
	public double act() {
		 return Math.sin(Math.toDegrees(myNumOne));
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
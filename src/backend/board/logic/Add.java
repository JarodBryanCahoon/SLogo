package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Add extends MathNode{
	
	public Add() {
		super();
	}

	@Override
	public double execute() {
		double sum = 0;
		for(ASTNode n:super.getChildren()) {
			sum+=n.execute();
		}
		return sum;
	}
}

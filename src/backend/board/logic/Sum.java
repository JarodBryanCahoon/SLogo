package backend.board.logic;

import backend.abstractsyntaxtree.ASTNode;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Sum extends MathNode{
	
	public Sum() {
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

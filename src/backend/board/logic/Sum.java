package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class creates a Sum Node.
 */
public class Sum extends MathNode{
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public Sum() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		double sum = 0;
		for(ASTNode n:super.getChildren()) {
			sum+=n.execute();
		}
		return sum;
	}
}

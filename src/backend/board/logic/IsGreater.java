package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon and Venkat Subramaniam
 * This class just creates a greater than node.
 */
public class IsGreater extends MathNode{
	/*
	 * The constructor just calls the super constructor.
	 */
	public IsGreater() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return (myNumOne>myNumTwo) ? 1:0;
	}

}
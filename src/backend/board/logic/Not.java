package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class just creates a Not node.
 */
public class Not extends MathNode{
	/*
	 * The constructor just calls the super class constructor.
	 */
	public Not() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		return (super.getChildren().get(0).execute() == 0) ? 1:0;
	}

}

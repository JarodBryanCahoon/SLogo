package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon and Venkat Subramaniam
 * This class creates a Minus node. 
 */
public class Minus extends MathNode{
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public Minus() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		return -super.getChildren().get(0).execute();
	}

}
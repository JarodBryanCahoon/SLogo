package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *This class creates a Remainder Node.
 */
public class Remainder extends MathNode{
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public Remainder() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	
	@Override
	public double execute() {
		return super.getChildren().get(0).execute()%super.getChildren().get(0).execute();
	}
}
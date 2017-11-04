package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This node creates an ATan command node.
 */
public class Atan extends MathNode{
	double myNumOne;
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public Atan() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		return Math.atan(Math.toDegrees(super.getChildren().get(0).execute()));
	}
}
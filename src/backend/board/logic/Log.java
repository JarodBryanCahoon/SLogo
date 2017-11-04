package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *This class just creates a Logarithm node.
 */
public class Log extends MathNode{
	/*
	 * The constructor calls the super constructor.
	 */
	public Log() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		return Math.log(super.getChildren().get(0).execute());
	}

}
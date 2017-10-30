package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Log extends MathNode{
	
	public Log() {
		super();
	}

	@Override
	public double execute() {
		return Math.log(super.getChildren().get(0).execute());
	}

}
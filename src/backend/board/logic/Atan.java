package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Atan extends MathNode{
	double myNumOne;
	
	public Atan() {
		super();
	}

	@Override
	public double execute() {
		return Math.atan(Math.toDegrees(super.getChildren().get(0).execute()));
	}
}
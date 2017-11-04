package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class And extends MathNode{

	
	public And() {
		super();
	}
	
	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return (myNumOne != 0 && myNumTwo != 0) ? 1:0;
	}
}
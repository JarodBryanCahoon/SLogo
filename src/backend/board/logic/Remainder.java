package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Remainder extends MathNode{
	
	public Remainder() {
		super();
	}


	@Override
	public double execute() {
		return super.getChildren().get(0).execute()%super.getChildren().get(0).execute();
	}
}
package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Minus extends MathNode{
	
	public Minus() {
		super();
	}
	
	@Override
	public double execute() {
		return -super.getChildren().get(0).execute();
	}

}
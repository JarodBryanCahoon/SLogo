package backend.board.logic;

import backend.abstractsyntaxtree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Not extends MathNode{
	
	public Not() {
		super();
	}
	
	@Override
	public double execute() {
		return (super.getChildren().get(0).execute() == 0) ? 1:0;
	}

}

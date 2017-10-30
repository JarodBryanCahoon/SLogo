package backend.board.logic;

import backend.abstractsyntaxtree.ASTNode;
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
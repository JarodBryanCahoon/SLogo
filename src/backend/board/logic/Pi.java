package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Pi extends NoParamMath{
	
	public Pi() {
	}
	

	@Override
	public double execute() {
		return Math.PI;
	}

}
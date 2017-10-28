package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Quotient extends MathNode{
	
	public Quotient() {
		super();
	}
	

	@Override
	public double execute() {
		double quotient = 0;
		for (ASTNode n: super.getChildren()) {
			quotient/=n.execute();
		}
		return quotient;
	}
}
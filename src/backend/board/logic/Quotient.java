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
		for (int i=0 ; i< super.getChildren().size()-1; i++) {
			if (i==0) {
				quotient = super.getChildren().get(i).execute();
			}
			quotient/=super.getChildren().get(i+1).execute();
		}
		return quotient;
	}
}
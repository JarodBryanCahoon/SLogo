package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkst Subramaniam
 * This class just creates a Quotient Node.
 */
public class Quotient extends MathNode{
	/*
	 * The constructor just calls the super constructor.
	 */
	public Quotient() {
		super();
	}
	

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
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
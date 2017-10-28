package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Difference extends MathNode{
	
	public Difference() {
		super();
	}

	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return myNumOne-myNumTwo;
	}

}
package backend.board.logic;

import backend.abstractsyntaxtree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subrmaniam
 *
 */
public class IsLess extends MathNode{
	public IsLess() {
		super();
	}

	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return (myNumOne<myNumTwo) ? 1:0;
	}

}
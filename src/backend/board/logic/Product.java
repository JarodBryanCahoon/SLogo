package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Product extends MathNode{
	
	public Product() {
		super();
	}
	
	@Override
	public double execute() {
		double product = 0;
		for (ASTNode n: super.getChildren()) {
			product*=n.execute();
		}
		return product;
	}
}
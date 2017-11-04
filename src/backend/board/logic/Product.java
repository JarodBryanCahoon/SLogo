package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class creates a product node.
 *
 */
public class Product extends MathNode{
	
	/*
	 * This constructor just calls the super constructor.
	 */
	public Product() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		double product = 1;
		for (ASTNode n: super.getChildren()) {
			product*=n.execute();
			
		}
		return product;
	}
}
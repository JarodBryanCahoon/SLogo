package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *This class creates a constant node that returns Pi.
 */
public class Pi extends NoParamMath{
	
	/*
	 * The constructor calls the super constructor.
	 */
	public Pi() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.NoParamMath#execute()
	 */
	@Override
	public double execute() {
		return Math.PI;
	}

}
package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;

/*
 * This class is a super class for math nodes that don't require parameters.
 */
public class NoParamMath implements ASTNode{
	
	/*
	 * The constructor just initializes the object.
	 */
	public NoParamMath() {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.abstractSyntaxTree.ASTNode#execute()
	 */
	@Override
	public double execute() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see backend.abstractSyntaxTree.ASTNode#setChildren(backend.abstractSyntaxTree.ASTNode)
	 */
	@Override
	public void setChildren(ASTNode n) {
		//this hopefully will never be reached
		
	}
}


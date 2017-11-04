package backend.board.logic;

import java.util.ArrayList;
import java.util.List;


import backend.abstractSyntaxTree.ASTNode;

/*
 * @author Venkat Subramaniam
 * This class is the super class for all of the math nodes.
 */
public class MathNode implements ASTNode{
	private List<ASTNode> myChildren;
	
	/*
	 * Constructor for this class.
	 * It just initializaes an list of children nodes.
	 */
	public MathNode() {
		myChildren = new ArrayList<>();
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
		myChildren.add(n);
	}

	/*
	 * This method is a protected one, used by the subclasses of this class to get a list of their children nodes.
	 */
	protected List<ASTNode> getChildren() {
		return myChildren;
	}
}

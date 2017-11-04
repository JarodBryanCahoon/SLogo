package backend.abstractSyntaxTree;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *This is an interface that allows one to create an executable abstract syntax tree.
 */
public interface ASTNode{
	
	/*
	 * This method enables the collapsing evaluation of the tree. Every node calls execute on its children, until
	 * the leaves of the tree, whose execution returns their own value.
	 */
	public double execute();
	
	/*
	 * This method allows the nodes to get to have their children nodes be set.
	 */
	public void setChildren(ASTNode n);
}

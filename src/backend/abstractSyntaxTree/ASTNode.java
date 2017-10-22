package backend.abstractSyntaxTree;


/* ASTNode.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree node.
 * @version 10.21.17
 */

public class ASTNode {
	private Expression val;
	private ASTNode left;
	private ASTNode right;
	
	public ASTNode(Expression e) {
		this.val = e;
	}
	
	public ASTNode(Expression e, ASTNode l, ASTNode r) {
		this.left = l;
		this.right = r;
		this.val = e;
	}
}

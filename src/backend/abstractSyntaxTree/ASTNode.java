package backend.abstractSyntaxTree;

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

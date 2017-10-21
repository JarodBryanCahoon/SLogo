package Interpreter;

public class ASTNode {
	private Expression val;
	private Expression left;
	private Expression right;
	
	public ASTNode(Expression e) {
		this.val = e;
	}
	
	public ASTNode(Expression e, Expression l, Expression r) {
		this.left = l;
		this.right = r;
		this.val = e;
	}
}

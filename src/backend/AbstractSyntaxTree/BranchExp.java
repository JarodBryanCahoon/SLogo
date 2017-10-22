package backend.AbstractSyntaxTree;

public class BranchExp extends Expression{
	boolean val;
	
	public BranchExp(boolean b) {
		this.val = b;
	}
}

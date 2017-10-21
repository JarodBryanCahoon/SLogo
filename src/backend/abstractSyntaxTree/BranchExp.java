package backend.abstractSyntaxTree;

public class BranchExp extends Expression{
	boolean val;
	
	public BranchExp(boolean b) {
		this.val = b;
	}
}

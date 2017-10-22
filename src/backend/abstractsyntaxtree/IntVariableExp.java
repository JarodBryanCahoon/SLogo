package backend.abstractSyntaxTree;

public class IntVariableExp extends Expression {
	private String name;
	private Integer val;
	
	public IntVariableExp(String s, IntegerExp e) {
		this.name=s;
		this.val = e.getVal();
	}
	
	public int getVal() {
		return this.val;
	}

}

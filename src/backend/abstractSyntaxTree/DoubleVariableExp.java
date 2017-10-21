package backend.abstractSyntaxTree;

public class DoubleVariableExp extends Expression{
	String name;
	double val;
	
	public DoubleVariableExp(String s, DoubleExp e) {
		this.name = s;
		this.val = e.getVal();
	}
	
	public double getVal() {
		return this.val;
	}
}

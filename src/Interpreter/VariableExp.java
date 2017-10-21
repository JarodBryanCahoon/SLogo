package Interpreter;

public class VariableExp extends Expression {
	private String name;
	private Integer val;
	
	public VariableExp(String s, IntegerExp e) {
		this.name=s;
		this.val = e.getVal();
	}
}

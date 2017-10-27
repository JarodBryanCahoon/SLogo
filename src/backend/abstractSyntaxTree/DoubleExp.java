package backend.abstractSyntaxTree;

public class DoubleExp extends Expression {
	private double val;
	private String myType = "double";
	
	public DoubleExp(double d) {
		this.val = d;
	}
	
	protected double getVal() {
		return this.val;
	}
	
	protected String getType() {
		return myType;
	}
}

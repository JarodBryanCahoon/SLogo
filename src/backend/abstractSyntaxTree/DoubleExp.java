package backend.abstractSyntaxTree;

public class DoubleExp extends Expression {
	private double val;
	private String myType = "double";
	
	public DoubleExp(double d) {
		this.val = d;
	}
	
	public double getVal() {
		return this.val;
	}
	
	public String getType() {
		return myType;
	}
}

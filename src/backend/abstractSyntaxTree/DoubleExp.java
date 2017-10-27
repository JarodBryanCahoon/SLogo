package backend.abstractSyntaxTree;

public class DoubleExp extends Expression {
	private double val;
	private String kind = "numberArgument";
	private String myType = "double";
	
	public DoubleExp(double d) {
		this.val = d;
	}
	
	public double getVal() {
		return this.val;
	}
	
	protected String getType() {
		return myType;
	}
	
	public String getKind() {
		return kind;
	}
}

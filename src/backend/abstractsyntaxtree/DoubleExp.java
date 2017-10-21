package backend.abstractsyntaxtree;

public class DoubleExp extends Expression {
	private double val;
	
	public DoubleExp(double d) {
		this.val = d;
	}
	
	public double getVal() {
		return this.val;
	}
}

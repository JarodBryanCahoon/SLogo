package backend.abstractSyntaxTree;

public class DuoOperatorExp extends OperatorExp {
	private double arg1;
	private double arg2;
	public DuoOperatorExp(String s) {
		super(s);
	}

	protected void setArgs(double a, double b) {
		arg1 = a;
		arg2 = b;
	}
	
	protected void operate() {
		//does this need to be here?
	}
}

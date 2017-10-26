package backend.abstractSyntaxTree;

public class MonoOperatorExp extends OperatorExp {
	private double arg;
	
	public MonoOperatorExp(String s) {
		super(s);
	}
	
	protected void setArg(double d) {
		arg = d;
	}
	protected void operate() {
		//does this need to be here?
	}


}

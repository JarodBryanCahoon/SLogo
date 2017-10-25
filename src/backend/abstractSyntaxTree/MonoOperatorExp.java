package backend.abstractSyntaxTree;

public class MonoOperatorExp extends OperatorExp {
	private double arg;
	private int type =1;
	
	public MonoOperatorExp(String s) {
		super(s);
	}
	
	public void setArg(double d) {
		arg = d;
	}
	public void operate() {
		//does this need to be here?
	}


}

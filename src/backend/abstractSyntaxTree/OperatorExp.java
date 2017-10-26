package backend.abstractSyntaxTree;

public class OperatorExp extends Expression{
	String name;
	int type;
	public OperatorExp(String s) {
		name=s;
	}
	
	protected int getType() {
		return type;
	}
	
}

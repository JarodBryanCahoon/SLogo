package backend.abstractSyntaxTree;

public class OperatorExp extends Expression{
	private String name;
	private String kind = "command";
//	private int type;
	public OperatorExp(String s) {
		name=s;
	}
	
//	protected int getType() {
//		return type;
//	}

	@Override
	public String getKind() {
		return kind;
	}

	@Override
	public double getVal() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

package backend.abstractSyntaxTree;



public class ListExp extends Expression{
	private String[] val;
	private String kind = "argument";
	
	public ListExp(String s) {
		val = s.substring(2,s.length()-1).split(" ");	
	}
	
	protected String[] getArg(){
		return val;
	}

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

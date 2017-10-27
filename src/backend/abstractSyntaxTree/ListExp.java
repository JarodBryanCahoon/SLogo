package backend.abstractSyntaxTree;



public class ListExp extends Expression{
	private String[] val;
	private String kind = "argument";
	
	public ListExp(String s) {
		val = s.substring(2,s.length()-1).split(" ");	
	}
	
	protected String[] getVal(){
		return val;
	}

	@Override
	public String getKind() {
		return kind;
	}
}

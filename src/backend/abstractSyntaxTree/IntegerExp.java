package backend.abstractSyntaxTree;

public class IntegerExp extends Expression {
	private Integer val;
	private String myType = "int";
	private String kind = "argument";
	public IntegerExp(int x) {
		this.val = x;
	}
	
//	public void setVal(int x) { //Maybe a completely unneccessary setter. 
//		this.val = x;
//	}
	
	protected Integer getVal() {
		return val;
	}
	
	protected String getType() {
		return myType;
	}
	
	public String getKind() {
		return kind;
	}
	
}

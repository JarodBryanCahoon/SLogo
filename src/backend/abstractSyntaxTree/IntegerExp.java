package backend.abstractSyntaxTree;

public class IntegerExp extends Expression {
	private Integer val;
	private String myType = "int";
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
	
}

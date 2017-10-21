package backend.abstractSyntaxTree;

public class IntegerExp extends Expression {
	private Integer val;
	
	public IntegerExp(int x) {
		this.val = x;
	}
	
//	public void setVal(int x) { //Maybe a completely unneccessary setter. 
//		this.val = x;
//	}
	
	public Integer getVal() {
		return val;
	}
}

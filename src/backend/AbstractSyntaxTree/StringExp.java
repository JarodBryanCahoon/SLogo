package backend.AbstractSyntaxTree;

public class StringExp extends Expression{
	private String val;
	
	public StringExp(String s) {
		this.val = s;
	}
}

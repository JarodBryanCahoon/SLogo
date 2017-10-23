package backend.abstractSyntaxTree;



public class ListExp extends Expression{
	private String[] val;
	
	public ListExp(String s) {
		val = s.split(" ");
		
		
	}
	
	public String[] getVal(){
		return val;
	}
}

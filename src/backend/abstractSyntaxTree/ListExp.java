package backend.abstractSyntaxTree;



public class ListExp extends Expression{
	private String[] val;
	
	public ListExp(String s) {
		val = s.substring(2,s.length()-1).split(" ");	
	}
	
	public String[] getVal(){
		return val;
	}
}

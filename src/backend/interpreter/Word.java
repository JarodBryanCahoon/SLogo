package backend.interpreter;

import backend.abstractSyntaxTree.Expression;
import backend.abstractSyntaxTree.*;

public class Word {
	private String myName;
	private String myType;
	private Expression myExpression;
	
	public Word(String s) {	
		myName = s.toLowerCase();
		determineType();
	}
	
	private void determineType() {
		if(myName.matches("^-?[0-9]+\\.[0-9]+$")){
			myType = "constant";
			myExpression = new DoubleExp(Double.parseDouble(myName));
		}
		else if(myName.matches("^-?[0-9]+$")){
			myType = "constant";
			myExpression = new IntegerExp(Integer.parseInt(myName));
		}
		else if(myName.matches("^:[a-zA-Z_]+$")) {
			myType = "variable";
			myExpression = new VariableExp(myName);
		}
		else if(myName.matches("^[a-zA-Z_]+(\\?)?$")) {
			myType = "command";
			myExpression = new OperatorExp(myName);
		}
//		else if (myName.matches("^#.*")) {
//			myType = "comment";
//		}	
		else {
			myType = "invalid";
		}
	}
	
	public Expression getExpression() {
		return myExpression;
	}
	
	public String getType() {
		return myType;
	}
}

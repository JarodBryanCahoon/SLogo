package backend.interpreter;

import java.util.Map;
import java.util.ResourceBundle;

import backend.abstractSyntaxTree.DoubleExp;
import backend.abstractSyntaxTree.DuoOperatorExp;
import backend.abstractSyntaxTree.Expression;
import backend.abstractSyntaxTree.ListExp;
import backend.abstractSyntaxTree.MonoOperatorExp;
import backend.abstractSyntaxTree.NoneOperatorExp;
import backend.abstractSyntaxTree.VariableExp;

public class Word {
	private String myName;
	private String myType;
	private Expression myExpression;
	private int operatorNumber;
//	private Map<String, Integer> commandNumbers = new HashMap<String, Integer>();
	
	
	public Word(String s, ResourceBundle resources, Map<String, Integer> commandNumbers) {	
		myName = s;
		determineType(resources, commandNumbers);
		
	}
	
	
	private void determineType(ResourceBundle rb, Map<String, Integer> map) {
		if(myName.matches("^-?[0-9]+.[0-9]+$")){
			myType = "Constant";
			myExpression = new DoubleExp(Double.parseDouble(myName));
		}
		else if(myName.matches("^:[a-zA-Z_]+$")) {
			myType = "Variable";
			myExpression = new VariableExp(myName);
		}
		else if(myName.matches("^[a-zA-Z_]+(\\?)?$")) {
			myType = "Command";
			try {
				String method = rb.getString(myName).split(",")[1];
				if (map.get(method)==0) {
					myExpression = new NoneOperatorExp(method);
					operatorNumber = 0;
				}
				if (map.get(method)==1) {
					myExpression = new MonoOperatorExp(method);
					operatorNumber = 1;
				}
				if(map.get(method)==2) {
					myExpression = new DuoOperatorExp(method);
					operatorNumber = 2;
				System.out.println("Everything worked");
				}
			}catch (Exception MissingResourceException) {
					myType = "Invalid";
			}
		}
	}


	public Expression getExpression() {
		return myExpression;
	}
	
	public String getType() {
		return myType;
	}
	
	public String getName() {
		return myName;
	
	}
	public int getNumber() {
		return operatorNumber;
	}
}

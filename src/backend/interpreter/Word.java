package backend.interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import backend.abstractSyntaxTree.DoubleExp;
import backend.abstractSyntaxTree.DuoOperatorExp;
import backend.abstractSyntaxTree.Expression;
import backend.abstractSyntaxTree.ListExp;
import backend.abstractSyntaxTree.MonoOperatorExp;
import backend.abstractSyntaxTree.NoneOperatorExp;
import backend.abstractSyntaxTree.VariableExp;
import exceptions.ErrorMessage;

/**
 * @author Albert
 *
 */
public class Word {
	private static final String CONSTANT = "Constant";
	private static final String VARIABLE = "Variable";
	private static final String COMMAND = "Command";
	private static final String PREFIX = "backend.board.interfacemovement.";
	private String myName;
	private String myType;
	private Expression myExpression;
	private int operatorNumber;
	private Properties myProperties;

//	private Map<String, Integer> commandNumbers = new HashMap<String, Integer>();
	
	
	public Word(String s, ResourceBundle resources, Map<String, Integer> commandNumbers) {	
		myName = s;
		SyntaxReader syntaxReader = new SyntaxReader();
		myProperties = syntaxReader.getProperties();
		determineType(resources, commandNumbers);
	}
	
	private void determineType(ResourceBundle rb, Map<String, Integer> map) {
		if(myName.matches(myProperties.getProperty(CONSTANT))){ 
			myType = CONSTANT;
			myExpression = new DoubleExp(Double.parseDouble(myName));
		}
		else if(myName.matches(myProperties.getProperty(VARIABLE))) {
			myType = VARIABLE;
			myExpression = new VariableExp(myName);
		}
		else if(myName.matches(myProperties.getProperty(COMMAND))) {
			myType = COMMAND;
			try {
				String method = rb.getString(myName).split(",")[1];
				System.out.println(method);
				method = PREFIX + method;
				System.out.println(map.entrySet());
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

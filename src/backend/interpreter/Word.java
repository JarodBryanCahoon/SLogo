package backend.interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.List;
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
import backend.board.Turtle;
import exceptions.ErrorMessage;

/**
 * @author Albert
 *
 */
public class Word {
	private static final String CONSTANT = "Constant";
	private static final String VARIABLE = "Variable";
	private static final String COMMAND = "Command";
	private String myName;
	private String myType;
	private String nodeType;
	private Expression myExpression;//myNode
	//private Node myNode;
	private int operatorNumber;
	private Properties myProperties;
	private List<Turtle> turtles;

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
			//myExpression = new DoubleExp(Double.parseDouble(myName));
			//myNode = new ConstantNode(Double.parseDouble(myName));
		}
		else if(myName.matches(myProperties.getProperty(VARIABLE))) {
			myType = VARIABLE;
			//myExpression = new VariableExp(myName);
			//myNode = new VariableNode(myName);
		}
		else if(myName.matches(myProperties.getProperty(COMMAND))) {
			myType = COMMAND;
			try {
				String method = rb.getString(myName).split(",")[1];
				String methodType = rb.getString(myName).split(",")[2];
				if (map.get(method)==0) {
					operatorNumber = 0;
				}
				if (map.get(method)==1) {
					operatorNumber = 1;
				}
				if(map.get(method)==2) {
					operatorNumber = 2;
				}
				Class<?> c = Class.forName(method);
				Constructor <?>ctr;
				//Node myNode;
				if (methodType.equals("Turtle")) {
					nodeType = "Turtle";
					ctr = c.getConstructor(List.class);
					//myNode =  (Node) ctr.newInstance(turtles);
				}
				else {
					ctr = c.getConstructor();
					//myNode = (Node) ctr.newInstance();
				}
				
				
			}catch (Exception MissingResourceException) {
					myType = "Invalid";
			}
		}
		else {
			myType = "Invalid";
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
	public static void main (String args[]) {
		String s = "34";
		
	}
}

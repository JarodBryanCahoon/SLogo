package backend.interpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import backend.abstractSyntaxTree.ASTNode;
//import backend.abstractSyntaxTree.DoubleExp;
//import backend.abstractSyntaxTree.DuoOperatorExp;
//import backend.abstractSyntaxTree.Expression;
//import backend.abstractSyntaxTree.ListExp;
//import backend.abstractSyntaxTree.MonoOperatorExp;
//import backend.abstractSyntaxTree.NoneOperatorExp;
//import backend.abstractSyntaxTree.VariableExp;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.board.logic.ConstantNode;
import backend.control.ListNode;
//import exceptions.ErrorMessage;
import backend.control.VariableNode;

/**
 * @author Venkat Subramaniam
 *
 */
public class Word {
	private static final String CONSTANT = "Constant";
	private static final String VARIABLE = "Variable";
	private static final String COMMAND = "Command";
	private static final String LIST = "List";
	private String myName;
	private String myType;
	private String nodeType;
	private ASTNode myNode;
	private int operatorNumber;
	private Properties myProperties;
	private TurtleCollection turtles;

//	private Map<String, Integer> commandNumbers = new HashMap<String, Integer>();
	
	
	public Word(String s, ResourceBundle resources, Map<String, Integer> commandNumbers, Map<String, VariableNode> variables, Map<String, List<Object>> myMap) {	
		myName = s;
		SyntaxReader syntaxReader = new SyntaxReader();
		myProperties = syntaxReader.getProperties();
		determineType(resources, commandNumbers, variables, myMap);
	}
	
	private void determineType(ResourceBundle rb, Map<String, Integer> map, Map<String, VariableNode> variables, Map<String, List<Object>> myMap) {
		if(myName.matches(myProperties.getProperty(CONSTANT))){ 
			makeConstantNode();
		}
		else if(myName.matches(myProperties.getProperty(VARIABLE))) {
			makeVariableNode(variables);
		}
		else if(myName.matches(myProperties.getProperty(LIST))){
			makeListNode(rb, myMap, variables);
		}
		else if(myName.matches(myProperties.getProperty(COMMAND))) {
			makeCommandNode(rb, map);
		}
		else {
			myType = "Invalid";
		}
	}
	
	private void makeListNode(ResourceBundle rb, Map<String, List<Object>> myMap, Map<String, VariableNode> variables) {
		myType = LIST;
		try {
			myNode = new ListNode(myName, myMap, variables);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void makeConstantNode() {
		myType = CONSTANT;
		myNode = new ConstantNode(Double.parseDouble(myName));
	}

	private void makeCommandNode(ResourceBundle rb, Map<String, Integer> map) {
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
				myNode =  (ASTNode) ctr.newInstance(turtles);
			}
			else {
				ctr = c.getConstructor();
				myNode = (ASTNode) ctr.newInstance();
			}
			
		}catch (Exception MissingResourceException) {
				myType = "Invalid";
		}
	}

	private void makeVariableNode(Map<String, VariableNode> variables) {
		myType = VARIABLE;
		if(variables.get(myName)==null) {
			myNode = new VariableNode(myName);
			variables.put(myName, (VariableNode) myNode);
		}
		else {
			myNode = variables.get(myName);
		}
	}
	
	public ASTNode getNode() {
		return myNode;
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

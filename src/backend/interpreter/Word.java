package backend.interpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.MissingResourceException;
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
import exceptions.SyntaxException;
import backend.control.ListNode;
//import exceptions.ErrorMessage;
import backend.control.VariableNode;

/**
 * @author Venkat Subramaniam, Albert
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
	private TurtleCollection myTurtles;
	private Map<String, String> myLanguageMap;


//	public Word(String s, ResourceBundle resources, TurtleCollection turtles, Map<String, VariableNode> variables, Map<String, String> languageMap) throws SyntaxException {
//		myName = s;
//		SyntaxReader syntaxReader = new SyntaxReader();
//		myProperties = syntaxReader.getProperties();
//		myTurtles = turtles;
//		myLanguageMap = languageMap;
//		determineType(resources);
//	}
//
//	private void determineType(ResourceBundle rb) throws SyntaxException {
//		if (myName.matches(myProperties.getProperty(CONSTANT))) {
//			myType = CONSTANT;
//			// myExpression = new DoubleExp(Double.parseDouble(myName));
//			 myNode = new ConstantNode(Double.parseDouble(myName));
//		} else if (myName.matches(myProperties.getProperty(VARIABLE))) {
//			myType = VARIABLE;
//			// myExpression = new VariableExp(myName);
////			 myNode = new VariableNode(myName);
//		} else if (myName.matches(myProperties.getProperty(COMMAND))) {
//			myType = COMMAND;
//			try {
//				String[] readString = rb.getString(myLanguageMap.get(myName)).split(",");
//				operatorNumber = Integer.parseInt(readString[0]);
//				String method = readString[1];
//				String methodType = readString[2];
//				Class<?> c = Class.forName(method);
//				Constructor<?> ctr;
//				// Node myNode;
//				if (methodType.equals("Turtle")) {
//					nodeType = "Turtle";
//					ctr = c.getConstructor(TurtleCollection.class);
//					myNode = (ASTNode) ctr.newInstance(myTurtles);
//				} else {
//					ctr = c.getConstructor();
//					myNode = (ASTNode) ctr.newInstance();
//				}
//			} catch (MissingResourceException | ClassNotFoundException | NoSuchMethodException | SecurityException
//					| InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException e) {
//				myType = "Invalid";
//			}
//		} else {
//=======

//	private Map<String, Integer> commandNumbers = new HashMap<String, Integer>();
	
	
	public Word(String s, ResourceBundle resources, TurtleCollection turtles, Map<String, VariableNode> variables, Map<String, String> languageMap) {	
		myName = s;
		myTurtles = turtles;
		SyntaxReader syntaxReader = new SyntaxReader();
		myProperties = syntaxReader.getProperties();
		myLanguageMap = languageMap;
		determineType(resources, variables);
	}
	
	private void determineType(ResourceBundle rb, Map<String, VariableNode> variables) {
		if(myName.matches(myProperties.getProperty(CONSTANT))){ 
			makeConstantNode();
		}
		else if(myName.matches(myProperties.getProperty(VARIABLE))) {
			makeVariableNode(variables);
		}
		else if(myName.matches(myProperties.getProperty(LIST))){
			makeListNode(rb, variables);
		}
		else if(myName.matches(myProperties.getProperty(COMMAND))) {
			System.out.println(myName);
			makeCommandNode(rb, variables);
		}
		else {
			System.out.println("invalid here");
			myType = "Invalid";
		} 
	}
	
	private void makeListNode(ResourceBundle rb, Map<String, VariableNode> variables) {
		myType = LIST;
		try {
			myNode = new ListNode(myName.substring(2,myName.length()-1), variables, myTurtles, myLanguageMap);
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

	private void makeCommandNode(ResourceBundle rb, Map<String, VariableNode> variables) {
		myType = COMMAND;
		try {
//			System.out.println("Actually invalid here");
			System.out.println("Hello" + myLanguageMap.get(myName.toLowerCase()));
			String[] readString = rb.getString(myLanguageMap.get(myName.toLowerCase())).split(",");
			System.out.println("hi");
			operatorNumber = Integer.parseInt(readString[0]);
			String method = readString[1];
			String methodType = readString[2];
			Class<?> c = Class.forName(method);
			Constructor<?> ctr;
			if (methodType.equals("Turtle")) {
				nodeType =methodType;
				System.out.println("Actually invalid here");
				ctr = c.getConstructor(TurtleCollection.class);
				myNode = (ASTNode) ctr.newInstance(myTurtles);
			} 
			else if(methodType.equals("Control")) {
				nodeType = methodType;
				ctr = c.getConstructor(Map.class);
				myNode = (ASTNode) ctr.newInstance(variables);
			}
			else {
				ctr = c.getConstructor();
				myNode = (ASTNode) ctr.newInstance();
			}
		} catch (MissingResourceException | ClassNotFoundException | NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException e) {
			
			myType = "Invalid";
		}
	
	}

	private void makeVariableNode(Map<String, VariableNode> variables) {
		myType = VARIABLE;
		if(!variables.containsKey(myName)) {
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

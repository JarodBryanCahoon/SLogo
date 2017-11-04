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
import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.board.logic.ConstantNode;
import exceptions.ErrorMessage;
import exceptions.SyntaxException;
import backend.control.CommandVariableNode;
import backend.control.ListNode;
import backend.control.VariableNode;

/**
 * @author Venkat Subramaniam
 * This is a class which enables one to create Word objects, which are assigned a type depending on what they are.
 * @version 10.31.17
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

	/*
	 * Constructor for this class. It takes in a string, a resource bundle, a turtle collection, a map of variables, and a language map.
	 * @param s, resources, turtles, variables, languageMap
	 */
	
	public Word(String s, ResourceBundle resources, TurtleCollection turtles, Map<String, VariableNode> variables, Map<String, String> languageMap) {	
		myName = s;
		myTurtles = turtles;
		SyntaxReader syntaxReader = new SyntaxReader();
		myProperties = syntaxReader.getProperties();
		myLanguageMap = languageMap;
		determineType(resources, variables);
	}
	
	/*
	 * This method enables the object to determine the type of input that it has received.
	 */
	private void determineType(ResourceBundle rb, Map<String, VariableNode> variables) {
		if(myName.matches(myProperties.getProperty(CONSTANT))){ 
			makeConstantNode();
		}
		else if(myName.matches(myProperties.getProperty(VARIABLE))) {
			
			if(variables.containsKey(myName)&&!variables.get(myName).isNumberVar()) {
				makeCommandNode(rb, variables);
			}
			else {
			makeVariableNode(variables);
			}
		}
		else if(myName.matches(myProperties.getProperty(LIST))){
			makeListNode(rb, variables);
		}
		else if(myName.matches(myProperties.getProperty(COMMAND))) {
			makeCommandNode(rb, variables);
		}
		else {
			myType = "Invalid";
		} 
	}
	
	/*
	 * This method creates and sets myNode to a List Node if it is called.
	 */
	private void makeListNode(ResourceBundle rb, Map<String, VariableNode> variables) {
		myType = LIST;
		try {
			myNode = new ListNode(myName.substring(2,myName.length()-1), variables, myTurtles, myLanguageMap);
		} catch (ClassNotFoundException e) {
			ErrorMessage eMessage = new ErrorMessage("Could Not Find Class");
			eMessage.show();
		} catch (FileNotFoundException e) {
			ErrorMessage eMessage = new ErrorMessage("Could Not Find File");
			eMessage.show();
		}
	}

	/*
	 * This method creates and sets myNode to a Constant Node if it is called.
	 */
	private void makeConstantNode() {
		myType = CONSTANT;
		myNode = new ConstantNode(Double.parseDouble(myName));
	}

	/*
	 * This method creates and sets myNode to a Command Node if it is called. 
	 */
	private void makeCommandNode(ResourceBundle rb, Map<String, VariableNode> variables) {
		myType = COMMAND;
		if (myName.startsWith(":")) {
			CommandVariableNode comm = (CommandVariableNode) variables.get(myName);
			operatorNumber = comm.getArgNum();
		}else {
		try {
			String[] readString = rb.getString(myLanguageMap.get(myName.toLowerCase())).split(",");
			operatorNumber = Integer.parseInt(readString[0]);
			String method = readString[1];
			String methodType = readString[2];
			Class<?> c = Class.forName(method);
			Constructor<?> ctr;
			if (methodType.equals("Turtle")) {
				nodeType =methodType;
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
	
	}

	/*
	 * This methods creates and sets myNode to a Variable Node when it is called.
	 */
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
	
	/*
	 * This is a public get method for myNode.
	 */
	public ASTNode getNode() {
		return myNode;
	}

	/*
	 * This is a public get method for the type of word this is. 
	 */
	public String getType() {
		return myType;
	}

	/*
	 * This is a public get method for the string of the Word.
	 */
	public String getName() {
		return myName;
	}

	/*
	 * This is a public get method that is used if the node is a command node, to get the number of arguments
	 * that the node takes.
	 */
	public int getNumber() {
		return operatorNumber;
	}
}

package backend.interpreter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.TurtleCollection;
import backend.board.logic.ConstantNode;
import exceptions.SyntaxException;

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
	// private Expression myExpression;//myNode
	private ASTNode myNode;
	// private Node myNode;
	private int operatorNumber;
	private Properties myProperties;
	private TurtleCollection myTurtles;
	private Map<String, String> myLanguageMap;


	public Word(String s, ResourceBundle resources, TurtleCollection turtles, Map<String, String> languageMap) throws SyntaxException {
		myName = s;
		SyntaxReader syntaxReader = new SyntaxReader();
		myProperties = syntaxReader.getProperties();
		myTurtles = turtles;
		myLanguageMap = languageMap;
		determineType(resources);
	}

	private void determineType(ResourceBundle rb) throws SyntaxException {
		if (myName.matches(myProperties.getProperty(CONSTANT))) {
			myType = CONSTANT;
			// myExpression = new DoubleExp(Double.parseDouble(myName));
			 myNode = new ConstantNode(Double.parseDouble(myName));
		} else if (myName.matches(myProperties.getProperty(VARIABLE))) {
			myType = VARIABLE;
			// myExpression = new VariableExp(myName);
//			 myNode = new VariableNode(myName);
		} else if (myName.matches(myProperties.getProperty(COMMAND))) {
			myType = COMMAND;
			try {
				String[] readString = rb.getString(myLanguageMap.get(myName)).split(",");
				operatorNumber = Integer.parseInt(readString[0]);
				String method = readString[1];
				String methodType = readString[2];
				Class<?> c = Class.forName(method);
				Constructor<?> ctr;
				// Node myNode;
				if (methodType.equals("Turtle")) {
					nodeType = "Turtle";
					ctr = c.getConstructor(TurtleCollection.class);
					myNode = (ASTNode) ctr.newInstance(myTurtles);
				} else {
					ctr = c.getConstructor();
					myNode = (ASTNode) ctr.newInstance();
				}
			} catch (MissingResourceException | ClassNotFoundException | NoSuchMethodException | SecurityException
					| InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException e) {
				myType = "Invalid";
			}
		} else {
			myType = "Invalid";
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

package backend.interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
//import exceptions.ErrorMessage;
import exceptions.ErrorMessage;
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

	public Word(String s, ResourceBundle resources, Map<String, Integer> commandNumbers, TurtleCollection turtles) throws SyntaxException {
		myName = s;
		SyntaxReader syntaxReader = new SyntaxReader();
		myProperties = syntaxReader.getProperties();
		myTurtles = turtles;
		determineType(resources, commandNumbers);
	}

	private void determineType(ResourceBundle rb, Map<String, Integer> map) throws SyntaxException {
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
				String method = rb.getString(myName).split(",")[1];
				String methodType = rb.getString(myName).split(",")[2];
				operatorNumber = map.get(method);
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
				} 
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException | MissingResourceException e) {
				myType = "Invalid";
			}
		} else {
			myType = "Invalid";
		} 
	}
	// public Expression getExpression() {
	// return myExpression;
	// }

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

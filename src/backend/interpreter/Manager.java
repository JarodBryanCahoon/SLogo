package backend.interpreter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

import backend.abstractSyntaxTree.ASTNode;

/*Manager.java
 * @author Venkat Subramaniam
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager extends Observable {
	private Map<String, ArrayList<?>> memory;
	private TextParse parser;
	
	
	public Manager() {
	}
	
	public void setCommand() {
		
	}
	
//	private ASTNode createTree() {
//		ASTNode myNode = new ASTNode();
//		return myNode;
//	}
}

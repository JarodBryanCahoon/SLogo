package backend.interpreter;

import java.util.ArrayList;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;

/*Manager.java
 * @author Venkat Subramaniam
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager {
	private Map<String, ArrayList<Object>> memory;
	private TextParse parser;
	private ASTNode root;
	public Manager() {
		parser = new TextParse();
		root = parser.getAST();
	}
	
	
	public void setCommand() {
		
	}
	
	private void executeCommands(ASTNode tree) {
		if (tree==null) {
			return;
		}
	}
//	private ASTNode createTree() {
//		ASTNode myNode = new ASTNode();
//		return myNode;
//	}
}

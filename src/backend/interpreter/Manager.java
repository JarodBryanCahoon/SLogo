package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;

/*Manager.java
 * @author Venkat Subramaniam
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager {
	private Map<String, List<Object>> memory;
	private TextParse parser;
	
	
	
	public Manager(String filename) throws ClassNotFoundException, FileNotFoundException {
	parser = new TextParse(memory, filename);
	}

	
	public void setCommand(String s) {
		parser.setCommands(s);
	}
	
	private void executeCommands() {
		ASTNode tree = parser.getAST();
		if (tree==null) {
			return;
		}
	}
//	private ASTNode createTree() {
//		ASTNode myNode = new ASTNode();
//		return myNode;
//	}
}

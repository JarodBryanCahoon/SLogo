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
	private TreeInterpreter treeInterpret;
	
	
	
	public Manager(String filename) throws ClassNotFoundException, FileNotFoundException {
	parser = new TextParse(memory, filename);
	}

	
	public void setCommand(String s) {
		parser.setCommands(s);
		treeInterpret = new TreeInterpreter(parser.getAST());
	}
	
//	private void executeCommands() {
//
//		if (tree==null) {
//			return;
//		}
//	}
}

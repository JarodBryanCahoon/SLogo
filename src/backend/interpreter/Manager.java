package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;
import backend.abstractSyntaxTree.ASTNode;

/*Manager.java
 * @author Venkat Subramaniam
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager {

	private Map<String, List<Object>> myMemory;
	private TextParse myParser;
	private int currentId;
	private double output;

	
	
	public Manager(String filename) throws ClassNotFoundException, FileNotFoundException {
		myParser = new TextParse(myMemory, filename);
	}

	
	public void setAndExecuteCommand(String s) {
		myParser.setCommands(s);
		ASTNode tree = myParser.getTree();
		output = tree.execute();
	}
	
	public double getOutput() {
		return output;
	}
	
	public void addTurtle() {
		
	}
	private void executeCommands() {
		
	}
}

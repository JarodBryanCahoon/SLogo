package backend.interpreter;

import backend.abstractSyntaxTree.ASTNode;


/*TextParse.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree after parsing lines of text.
 * @version 10.21.17
 */
public class TextParse {
	private ASTNode root;
	private String commands;
	
	public TextParse(String s) {
		commands = s;
	}
	
	private void makeTree() {
		String[] commandList = commands.split(" ");
		for (String s: commandList) {
			
		}
	}

	public ASTNode getAST() {
		return root;
	}
}

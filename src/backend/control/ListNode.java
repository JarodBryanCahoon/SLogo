package backend.control;

import java.io.FileNotFoundException;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.TurtleCollection;
import backend.board.logic.NoParamMath;
import backend.interpreter.TextParse;

/*
 * @author Venkat Subramaniam
 * This class allows lists of commands and constants to be stored in the tree as is to be evaluated and constructed
 * into part of the tree at a later time, should it be necessary.
 */
public class ListNode extends NoParamMath{
	private String contents;
	private TextParse parser;
	private TurtleCollection turtles;
	
	/*
	 * The constructor takes in an input string, a map of variables, a turtle collection, and a map of langauges.
	 * @param input
	 * @param vars
	 * @param turtle
	 * @param languages
	 */
	public ListNode(String input, Map<String, VariableNode> vars, TurtleCollection turtle, Map<String, String> languages) throws ClassNotFoundException, FileNotFoundException {
		contents= input;
		parser = new TextParse(vars);
		parser.setLanguageMap(languages);
		turtles = turtle;
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.NoParamMath#execute()
	 */
	@Override
	public double execute() {
		parser.setCommands(contents, turtles);
		ASTNode tree = parser.getTree();
		return tree.execute();
	}
	
	/*
	 * This public method returns the commands as an array with the whitespaces omitted. 
	 */
	public String[] getContents() {
		return contents.split(" ");
	}
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.NoParamMath#setChildren(backend.abstractSyntaxTree.ASTNode)
	 */
	@Override
	public void setChildren(ASTNode n) {
	}

}

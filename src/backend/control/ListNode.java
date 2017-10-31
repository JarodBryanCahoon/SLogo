package backend.control;

import java.io.FileNotFoundException;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.TurtleCollection;
import backend.board.logic.NoParamMath;
import backend.interpreter.TextParse;

public class ListNode extends NoParamMath{
	private String contents;
	private TextParse parser;
	private TurtleCollection turtles;
	
	public ListNode(String input, Map<String, VariableNode> vars, TurtleCollection turtle, Map<String, String> languages) throws ClassNotFoundException, FileNotFoundException {
		contents= input;
		parser = new TextParse(vars);
		parser.setLanguageMap(languages);
		turtles = turtle;
	}
	
	@Override
	public double execute() {
		parser.setCommands(contents, turtles);
		ASTNode tree = parser.getTree();
		return tree.execute();
	}
	
	public String[] getContents() {
		return contents.split(" ");
	}

}

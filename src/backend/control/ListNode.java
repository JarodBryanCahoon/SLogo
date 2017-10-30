package backend.control;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;

import backend.abstractsyntaxtree.ASTNode;
import backend.board.TurtleCollection;
import backend.board.logic.NoParamMath;
import backend.interpreter.TextParse;

public class ListNode extends NoParamMath{
	private String contents;
	private TextParse parser;
	private TurtleCollection turtles;
	
	public ListNode(String input, Map<String, VariableNode> vars, TurtleCollection turtle) throws ClassNotFoundException, FileNotFoundException {
		contents= input;
		parser = new TextParse(vars);
		turtles = turtle;
	}
	
	@Override
	public double execute() {
		parser.setCommands(contents, turtles);
		ASTNode tree = parser.getTree();
		return tree.execute();
	}

}

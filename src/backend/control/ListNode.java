package backend.control;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.logic.NoParamMath;
import backend.interpreter.TextParse;

public class ListNode extends NoParamMath{
	private String contents;
	private TextParse parser;
	
	public ListNode(String input, Map<String, List<Object>> myMap, Map<String, VariableNode> vars) throws ClassNotFoundException, FileNotFoundException {
		contents= input;
		parser = new TextParse(myMap, vars);
	}
	
	@Override
	public double execute() {
		parser.setCommands(contents);
		ASTNode tree = parser.getTree();
		return tree.execute();
	}

}

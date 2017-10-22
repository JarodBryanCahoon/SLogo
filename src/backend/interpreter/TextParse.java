package backend.interpreter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

import backend.abstractSyntaxTree.ASTNode;


/*TextParse.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree after parsing lines of text.
 * @version 10.21.17
 */
public class TextParse {
	private ASTNode root;
	private String commands;
	private Map<String, ArrayList<Object>> myMap;
	
	public TextParse(String s, Map<String, ArrayList<Object>> map) {
		commands = s;
		myMap = map;
	}
	
	private void makeTree() {
		String[] lineList = commands.split("/n");
		Stack commandStack = new Stack();
		Stack argumentStack = new Stack();
		for (String s: lineList) {
			s=s.trim();
			if (s.startsWith("#")){
				addToComments(s);
				continue;
			}
			String[] commandList = s.split(" ");
			for (String t: commandList) {
				Word w = new Word(t);
				if (w.getType().equals("command")) {
					
				}
			}
		}
	}

	private void addToComments(String s) {
		if (!myMap.containsKey("Comments")){
			myMap.put("Comments", new ArrayList<Object>());
		}
		myMap.get("Comments").add(s);
		
	}

	public ASTNode getAST() {
		return root;
	}
}

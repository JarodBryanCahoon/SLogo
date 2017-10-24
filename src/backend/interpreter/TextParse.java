package backend.interpreter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

import backend.abstractSyntaxTree.ASTNode;
import backend.abstractSyntaxTree.Expression;


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
		makeTree();
	}
	
	private void makeTree() {
		String[] lineList = commands.split("/n");
		
		for (String s: lineList) {
			s=s.trim();
			if (s.startsWith("#")){
				addToComments(s);
				continue;
			}
			s= "";
		}
		String s = String.join(" ", lineList);
//		Stack<?>[] stacks = fillStacks(s, commandStack, argumentStack, comm);
		Stack<?> [] stacks = fillStacks(s);		
		ASTNode tree = makeTreeFromStacks((Stack<CommandNumber>) stacks[0], (Stack<ASTNode>) stacks[1]);
		root=tree;
	}


	private ASTNode makeTreeFromStacks(Stack<CommandNumber> commandStack, Stack<ASTNode> argumentStack) {
		ASTNode tree = null;
		
		while (!commandStack.isEmpty()) {
			
			CommandNumber comm =  commandStack.pop();
			ASTNode[] e = new ASTNode[comm.getNumber()];
			for (int i=0; i<comm.getNumber(); i++) {
				ASTNode fun = (argumentStack.pop());
				e[i] = fun;
			}
			
			
		}
		return root;
	}

	private Stack<?>[] fillStacks(String s) {
		Stack<CommandNumber> commandStack = new Stack<>();
		Stack<ASTNode> argumentStack = new Stack<>();
		CommandNumber comm=null;
		String[] commandList = s.split(" ");
		for (int i=0; i<commandList.length; i++) {
			String t = commandList[i];
			if (t.equals("[")) {
				StringBuilder sb = new StringBuilder();
				int j=i;
				while(!commandList[j].equals("]")) {
					sb.append(commandList[j]);
					sb.append(" ");
					j++;
				}
				sb.append("]");
				t=sb.toString();
				i=j;
			}
			Word w = new Word(t);
			if (w.getT .equals("command")) {
				if(comm!=null) {
				comm.setExpression();
				}
				comm = new CommandNumber(w.getExpression());
				commandStack.push(comm);
			}
			else {
				if (w.getType().equals("list")){
					comm.setbool();
				}
				argumentStack.push((new ASTNode(w.getExpression())));
				comm.increment();
	}
		}
		Stack<?>[] fun = new Stack<?> [2];
		fun[0] = commandStack;
		fun[1] = argumentStack;
		return fun;
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

package backend.interpreter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;


import backend.abstractSyntaxTree.ASTNode;
import backend.abstractSyntaxTree.Expression;


/*TextParse.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree after parsing lines of text.
 * @version 10.21.17
 */
public class TextParse {
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private ASTNode root;
	private String commands;
	private Map<String, ArrayList<Object>> myMap;
	private Map<String, Integer> CommandNumbers;
	private ResourceBundle rb;
	private Queue<Word> queue;
	
	public TextParse(String s, Map<String, ArrayList<Object>> map, String filename) throws ClassNotFoundException {
		commands = s;
		myMap = map;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + filename);
		makeCommandNumbers();
		makeTree();
	}
	
	private void makeCommandNumbers() throws ClassNotFoundException {
		CommandNumbers = new HashMap<String, Integer>();
		ArrayList<String> classList = new ArrayList<>();
		classList.add("backend.board.BoardMath");
		classList.add("backend.board.Turtle");
		for(String s: classList) {
			Class<?> c = Class.forName(s);
			Method[] m = c.getDeclaredMethods();
			for(Method i:m) {
				CommandNumbers.put(i.getName(), i.getParameterCount());
			}
		}
		
	}

	private void makeTree() {
		String[] lineList = commands.split("/n");
		
		for (String s: lineList) {
			s=s.trim();
			if (s.startsWith("#")){
				addToComments(s);
				s= "";
				continue;
			}
		}
		String s = String.join(" ", lineList);
		queue = new LinkedList<>();
		String[] commandList = s.split(" ");
		for(int i = 0; i<commandList.length; i++) {
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
			Word w = new Word(t, rb, CommandNumbers);
			queue.add(w);
		}
		root = recursiveTree();
	}


//	private ASTNode recursiveTree() {
////		String[] commandList = s.split(" "); 
//		ASTNode tree=null;
//		for (int i=0; i<commandList.length; i++) {
//			String t = commandList[i];
//			if (t.equals("[")) {
//				StringBuilder sb = new StringBuilder();
//				int j=i;
//				while(!commandList[j].equals("]")) {
//					sb.append(commandList[j]);
//					sb.append(" ");
//					j++;
//				}
//				sb.append("]");
//				t=sb.toString();
//				i=j;
//			}
//			Word w = new Word(t, rb, CommandNumbers);
//		    tree = new ASTNode(w.getExpression());
//		    if(w.getType().equals("command")) {
//		    		if (w.getNumber()==0) {
//		    			return tree;
//		    		}
//		    		if(w.getNumber()==1) {
//		    			tree.setRight(null);
//		    			tree.setLeft(recursiveTree(Arrays.copyOfRange(commandList, 1,commandList.length-1 )));
//		    		}
//		    		if (w.getNumber()==2) {
//		    			tree.set
//		    		}
//		    }
//		
//		
//		}
//		return tree;
	private ASTNode recursiveTree() {
		Word w = queue.poll();
		ASTNode tree = new ASTNode(w.getExpression());
		if(w.getType().equals("command")) {
			if(w.getNumber()==0) {
				return tree;
			}
			if(w.getNumber()==1) {
				tree.setRight(null);
				tree.setLeft(recursiveTree());
			}
			if(w.getNumber()==2) {
				tree.setLeft(recursiveTree());
				tree.setRight(recursiveTree());
			}
		}
		return tree;
	}

//	private ASTNode makeTreeFromStacks(Stack<CommandNumber> commandStack, Stack<ASTNode> argumentStack) {
//		ASTNode tree = null;
//		
//		while (!commandStack.isEmpty()) {
//			CommandNumber comm =  commandStack.pop();
//			ASTNode[] e = new ASTNode[comm.getNumber()];
//			for (int i=0; i<comm.getNumber(); i++) {
//				ASTNode fun = (argumentStack.pop());
//				e[i] = fun;
//			}
//			
//			
//		}
//		return root;
//	}

//	private Stack<?>[] fillStacks(String s) {
//		Stack<CommandNumber> commandStack = new Stack<>();
//		Stack<ASTNode> argumentStack = new Stack<>();
//		CommandNumber comm=null;
//		String[] commandList = s.split(" ");
//		for (int i=0; i<commandList.length; i++) {
//			String t = commandList[i];
//			if (t.equals("[")) {
//				StringBuilder sb = new StringBuilder();
//				int j=i;
//				while(!commandList[j].equals("]")) {
//					sb.append(commandList[j]);
//					sb.append(" ");
//					j++;
//				}
//				sb.append("]");
//				t=sb.toString();
//				i=j;
//			}
//			Word w = new Word(t);
//			if (w.getT .equals("command")) {
//				if(comm!=null) {
//				comm.setExpression();
//				}
//				comm = new CommandNumber(w.getExpression());
//				commandStack.push(comm);
//			}
//			else {
//				if (w.getType().equals("list")){
//					comm.setbool();
//				}
//				argumentStack.push((new ASTNode(w.getExpression())));
//				comm.increment();
//	}
//		}
//		Stack<?>[] fun = new Stack<?> [2];
//		fun[0] = commandStack;
//		fun[1] = argumentStack;
//		return fun;
//	}
	
	
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

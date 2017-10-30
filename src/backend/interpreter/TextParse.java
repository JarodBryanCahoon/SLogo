package backend.interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Scanner;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.logic.Tan;
import backend.control.VariableNode;



/*TextParse.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree after parsing lines of text.
 * @version 10.21.17
 */
public class TextParse {
	private static final String NEWLINE = "Newline";
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private static final String DEFAULT_COMMAND_MAP = "ArgumentNumbers";
	public static final String CLASS_LIST = "ClassList.txt";
	private ASTNode root;
	private Map<String, List<Object>> myMap;
	private Map<String, Integer> CommandNumbers;
	private Map<String, VariableNode> variables;
	private ResourceBundle rb;
	private Queue<Word> queue = new LinkedList<>();
	private Properties myProperties;
	
	public TextParse() throws ClassNotFoundException, FileNotFoundException {
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "ArgumentNumbers");
		createSyntaxReader();
	}
	
	public TextParse(Map<String, List<Object>> map, Map<String, VariableNode> vars) throws ClassNotFoundException, FileNotFoundException {
		myMap = map;
		variables = vars;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE +DEFAULT_COMMAND_MAP);
		createSyntaxReader();
	}

	private void createSyntaxReader() throws ClassNotFoundException, FileNotFoundException {
		makeCommandNumbers();
		SyntaxReader sReader = new SyntaxReader();
		myProperties = sReader.getProperties();
	}
	
	public void setCommands(String s) {
		makeTree(s);
	}
	
	private void makeCommandNumbers() throws ClassNotFoundException, FileNotFoundException {
		CommandNumbers = new HashMap<String, Integer>();
		
		Enumeration<String> enuKeys = rb.getKeys();
		while (enuKeys.hasMoreElements()) {
			String key = rb.getString(enuKeys.nextElement());
			String[] list = key.split(",");
			CommandNumbers.put(list[1], Integer.parseInt(list[0]));
		}
		
	}

	private void makeTree(String commands) {
		String[] lineList = commands.split(myProperties.getProperty(NEWLINE));	
		for (String s: lineList) {
			s=s.trim();
			if (s.startsWith("#")){
				addToComments(s);
				s= "";
				continue;
			}
		}
		String s = String.join(" ", lineList);
		fillCommandQueue(s);
		root = recursiveTree();
	}

	private void fillCommandQueue(String s) {
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
			Word w = new Word(t, rb, CommandNumbers, variables, myMap);
			
			queue.add(w);
		}
	}


	private ASTNode recursiveTree() {
		Word w = queue.poll();
		ASTNode tree = w.getNode();
		if(w.getType().equals("Command")) {
			for(int i = 0; i<w.getNumber(); i++) {
				tree.setChildren(recursiveTree());
			}
		}
		return tree;
	}
	
	private void addToComments(String s) {
		if (!myMap.containsKey("Comments")){
			myMap.put("Comments", new ArrayList<Object>());
		}
		myMap.get("Comments").add(s);
		
	}

	public ASTNode getTree() {
		return root;
	}
	
	public Word[] getWordsWithSpaces(String s) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
			System.out.println(commandList[k]);
			Word word = new Word(commandList[k], rb, CommandNumbers, variables, myMap);
			sentence[k] = word;
		}
		return sentence;
	}
	
}

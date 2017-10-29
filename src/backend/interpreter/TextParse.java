package backend.interpreter;

import java.io.FileNotFoundException;
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

import backend.abstractSyntaxTree.ASTNode;
import backend.board.TurtleCollection;

/*TextParse.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree after parsing lines of text.
 * @version 10.21.17
 */
public class TextParse {
	private static final String COMMENT = "Comment";
	private static final String LIST_END = "ListEnd";
	private static final String LIST_START = "ListStart";
	private static final String WHITESPACE = "Whitespace";
	private static final String NEWLINE = "Newline";
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	public static final String CLASS_LIST = "ClassList.txt";
	private ASTNode root;
	private Map<String, List<Object>> myMap;
	private Map<String, Integer> CommandNumbers;
	private ResourceBundle rb;
	private Queue<Word> queue = new LinkedList<>();
	private Properties myProperties;
	
	public TextParse() throws ClassNotFoundException, FileNotFoundException {
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "ArgumentNumbers");
		createSyntaxReader();
	}
	
	public TextParse(Map<String, List<Object>> map, String filename) throws ClassNotFoundException, FileNotFoundException {
		myMap = map;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + filename);
		createSyntaxReader();
	}

	private void createSyntaxReader() throws ClassNotFoundException, FileNotFoundException {
		makeCommandNumbers();
		SyntaxReader sReader = new SyntaxReader();
		myProperties = sReader.getProperties();
	}
	
	public void setCommands(String s, TurtleCollection turtles) {
		makeTree(s, turtles);
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

	private void makeTree(String commands, TurtleCollection turtles) {
		String[] lineList = commands.split(myProperties.getProperty(NEWLINE));	
		for (String s: lineList) {
			s=s.trim();
			if (s.equals(myProperties.getProperty(COMMENT))){
				System.out.println("This is a comment");
				addToComments(s);
				s= "";
				continue;
			}
		}
		System.out.println(Arrays.toString(lineList));
		String s = String.join(" ", lineList);
		System.out.println(s);
		fillCommandQueue(s, turtles);
		root = recursiveTree();
	}

	private void fillCommandQueue(String s, TurtleCollection turtles) {
		String[] commandList = s.split(myProperties.getProperty(WHITESPACE));
		System.out.println(Arrays.toString(commandList));
		System.out.println("-----------");
		for(int i = 0; i<commandList.length; i++) {
			String t = commandList[i];
			if (t.equals(myProperties.getProperty(LIST_START))) {
				StringBuilder sb = new StringBuilder();
				int j=i;
				while(!commandList[j].equals(myProperties.getProperty(LIST_START))) {
					sb.append(commandList[j]);
					sb.append(" ");
					j++;
				}
				sb.append(myProperties.getProperty(LIST_END));
				t=sb.toString();
				i=j;
			}
			Word w = new Word(t, rb, CommandNumbers, turtles);
			
			queue.add(w);
		}
	}


	private ASTNode recursiveTree() {
		Word w = queue.poll();
		ASTNode tree = w.getNode();
		if(w.getType().equals("Command")) {
//			if(w.getNumber()==0) {
//				return tree;
//			}
//			if(w.getNumber()==1) {
//				tree.setChildren((recursiveTree()));
//			}
//			if(w.getNumber()==2) {
//				tree.setChildren(recursiveTree());
//				tree.setChildren(recursiveTree());
//			}
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
	
	public Word[] getWordsWithSpaces(String s, TurtleCollection turtles) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
//			System.out.println(commandList[k]);
			Word word = new Word(commandList[k], rb, CommandNumbers, turtles);
			sentence[k] = word;
		}
		return sentence;
	}
	
}

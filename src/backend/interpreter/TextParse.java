package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.ResourceBundle;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.TurtleCollection;
import backend.control.VariableNode;
import exceptions.SyntaxException;



/*TextParse.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree after parsing lines of text.
 * @version 10.31.17
 */
public class TextParse {
	private static final String COMMENT = "Comment";
	private static final String LIST_END = "ListEnd";
	private static final String LIST_START = "ListStart";
	private static final String WHITESPACE = "Whitespace";
	private static final String NEWLINE = "Newline";
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private static final String DEFAULT_COMMAND_MAP = "ArgumentNumbers";
	public static final String CLASS_LIST = "ClassList.txt";
	private static final String COMMAND = "Command";
	private ASTNode root;
	private Map<String, VariableNode> variables;
	private ResourceBundle rb;
	private Queue<Word> queue = new LinkedList<>();
	private Properties myProperties;
	private Map<String, String> languageMap;
	
	/*
	 * Constructor for this class. Takes a single map of variables and constructs the resource bundle 
	 * and syntax reader.
	 * @param vars
	 */
	public TextParse(Map<String, VariableNode> vars) throws ClassNotFoundException, FileNotFoundException {
		variables = vars;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE +DEFAULT_COMMAND_MAP);
		createSyntaxReader();
	}
	
	/*
	 * This method enables one to change the language used to parse commands.
	 */
	public void changeLanguage(Properties languageFile) { 
		languageMap = new HashMap<>(); 
		for(Object key : languageFile.keySet()) { 
		  String s = key.toString(); 
		  String[] commands = languageFile.getProperty(s).split("\\|"); 
		  for(String command : commands) {
			  if(command.matches("\\*")) {
				  	command = "\\" + command;
			  }
		    languageMap.put(command, s); 
		  }
		}
	} 

	/*
	 * This method creates the syntax reader.
	 */
	private void createSyntaxReader() throws ClassNotFoundException, FileNotFoundException {
		SyntaxReader sReader = new SyntaxReader();
		myProperties = sReader.getProperties();
	}
	
	/*
	 * This method is a public one which allows the current commands to be set.
	 */
	public void setCommands(String s, TurtleCollection turtles) {
		makeTree(s, turtles);
	}

	/*
	 * This method parses the text, gets rid of whitespaces and comments.
	 */
	private void makeTree(String commands, TurtleCollection turtles) {
		String[] lineList = commands.split(myProperties.getProperty(NEWLINE));	
		for (String command: lineList) {
			command=command.trim();
			if (command.equals(myProperties.getProperty(COMMENT))){
				command= "";
				continue;
			}
		}
		String s = String.join(" ", lineList);
		s = s.trim();
		fillCommandQueue(s, turtles);
		root = recursiveTree();
		if (!queue.isEmpty()) {
			root.execute();
			root = recursiveTree();
		}
	}

	/*
	 * This method fills the queue data structure with Word objects, which will later be used to construct
	 * an abstract syntax tree.
	 */
	private void fillCommandQueue(String s, TurtleCollection turtles) {
		String[] commandList = s.split(myProperties.getProperty(WHITESPACE));
		for(int i = 0; i<commandList.length; i++) {
			String t = commandList[i];
			if (t.equals(myProperties.getProperty(LIST_START))) {
				StringBuilder sb = new StringBuilder();
				int j=i;
				while(!commandList[j].equals(myProperties.getProperty(LIST_END))) {
					if (j>=commandList.length) {
						throw new SyntaxException();			
					}
					sb.append(commandList[j]);
					sb.append(" ");
					j++;
					
				}
				sb.append(myProperties.getProperty(LIST_END));
				t=sb.toString();
				i=j;
			}
			Word w = new Word(t, rb, turtles, variables, languageMap);
			queue.add(w);
		}
	}

	/*
	 * This method recursively creates the abstract syntax tree from the commands given to it using the previously
	 * filled command queue.
	 */

	private ASTNode recursiveTree() {
		if (queue.isEmpty()) {
			throw new SyntaxException();
		}
		Word w = queue.poll();
		ASTNode tree = w.getNode();
		if(w.getType().equals(COMMAND)) {
			for(int i = 0; i<w.getNumber(); i++) {
				tree.setChildren(recursiveTree());
				
			}
		}
		return tree;
	}
	
	/*
	 * This is a public get method for the abstract syntax tree.
	 */

	public ASTNode getTree() {
		return root;
	}
	
	/*
	 * This returns an array of words, including the whitespaces, so that the front end can display the words along
	 * with their types (commands, constants, etc).
	 */
	public Word[] getFormattedSentence(String s, TurtleCollection turtles) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
			Word word = new Word(commandList[k], rb, turtles, variables, languageMap);
			sentence[k] = word;
		}
		return sentence;
	}
	
	/*
	 * This is a public method which enables one to set the language map of the TextParse object should it be 
	 * necessary.
	 */
	public void setLanguageMap(Map<String, String> map) {
		languageMap = map;
	}
	
}

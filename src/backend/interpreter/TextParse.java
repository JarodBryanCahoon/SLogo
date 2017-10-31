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
 * @version 10.21.17
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
	
	public TextParse(Map<String, VariableNode> vars) throws ClassNotFoundException, FileNotFoundException {
		variables = vars;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE +DEFAULT_COMMAND_MAP);
		createSyntaxReader();
	}
	
	public void changeLanguage(Properties languageFile) { 
	    languageMap = new HashMap<>(); 
	    for(Object key : languageFile.keySet()) { 
	      String s = key.toString(); 
	      String[] commands = languageFile.getProperty(s).split("\\|"); 
	      for(String command : commands) { 
	        languageMap.put(command, s); 
	      } 
	    } 
	  } 

	private void createSyntaxReader() throws ClassNotFoundException, FileNotFoundException {
		SyntaxReader sReader = new SyntaxReader();
		myProperties = sReader.getProperties();
	}
	
	public void setCommands(String s, TurtleCollection turtles) {
		makeTree(s, turtles);
	}

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
//			throw new SyntaxException(); 
			root.execute();
			root = recursiveTree();
		}
	}

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
			System.out.print(w.getName() +" : " );
			System.out.println(w.getType());
			
			queue.add(w);
		};
	}


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
	

	public ASTNode getTree() {
		return root;
	}
	
	public Word[] getFormattedSentence(String s, TurtleCollection turtles) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
			Word word = new Word(commandList[k], rb, turtles, variables, languageMap);
			sentence[k] = word;
		}
		return sentence;
	}
	
	public void setLanguageMap(Map<String, String> map) {
		languageMap = map;
	}
	
}

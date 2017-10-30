package backend.interpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
	private Map<String, String> languageMap;
	
	public TextParse() throws ClassNotFoundException, FileNotFoundException {
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "ArgumentNumbers");
//		InputStream input = new FileInputStream("src/resources/languages/Chinese.properties");
//		Properties lang = new Properties();
//		try {
//			lang.load(input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		changeLanguage(lang);
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
		

	public TextParse(Map<String, List<Object>> map, String filename) throws ClassNotFoundException, FileNotFoundException {
		myMap = map;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + filename);
		createSyntaxReader();
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
				addToComments(command);
				command= "";
				continue;
			}
		}
		String s = String.join(" ", lineList);
		fillCommandQueue(s, turtles);
		root = recursiveTree();
	}

	private void fillCommandQueue(String s, TurtleCollection turtles) {
		String[] commandList = s.split(myProperties.getProperty(WHITESPACE));
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
			Word w = new Word(t, rb,turtles, languageMap);
			
			queue.add(w);
		};
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
	
	public Word[] getFormattedSentence(String s, TurtleCollection turtles) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
//			System.out.println(commandList[k]);

			Word word = new Word(commandList[k], rb, turtles, languageMap);
			sentence[k] = word;
		}
		return sentence;
	}
	
}

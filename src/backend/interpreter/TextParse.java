package backend.interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
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


/*TextParse.java
 * @author Venkat Subramaniam
 * Class that creates an AbstractSyntaxTree after parsing lines of text.
 * @version 10.21.17
 */
public class TextParse {
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
		makeCommandNumbers();
//		SyntaxReader sReader = new SyntaxReader();
//		myProperties = sReader.getProperties();
	}
	
	public TextParse(Map<String, List<Object>> map, String filename) throws ClassNotFoundException, FileNotFoundException {
		myMap = map;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + filename);
		makeCommandNumbers();
//		SyntaxReader sReader = new SyntaxReader();
//		myProperties = sReader.getProperties();
		// please refactor this venkat
	}
	
	public void setCommands(String s) {
		makeTree(s);
	}
	
	private void makeCommandNumbers() throws ClassNotFoundException, FileNotFoundException {
		CommandNumbers = new HashMap<String, Integer>();
//		File fl = new File("src/resources/"+CLASS_LIST);
//		Scanner scan = new Scanner(fl);
//		ArrayList<String> classList = new ArrayList<>();
//		while(scan.hasNextLine()) {
//			String st = scan.nextLine();
//			classList.add(st);
//			Class<?> c = Class.forName(st);
//			Constructor<?>[] cons = c.getConstructors();
//			for(Constructor<?> con : cons) {
//				//returns the parameter numbers for the constructors.
//				CommandNumbers.put(c.getName(), con.getParameterCount());
//			}
//		}
		Enumeration<String> enuKeys = rb.getKeys();
		while (enuKeys.hasMoreElements()) {
			String key = enuKeys.nextElement();
			String[] fun = rb.getString(key).split(",");
			if(CommandNumbers.get(fun[1])==0) {
				CommandNumbers.put(fun[1], Integer.parseInt(fun[0]));
			}
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
			Word w = new Word(t, rb, CommandNumbers);
			
			queue.add(w);
		}
	}


	private ASTNode recursiveTree() {
		Word w = queue.poll();
		ASTNode tree = new ASTNode(w.getExpression());
		if(w.getType().equals("Command")) {
			if(w.getNumber()==0) {
				return tree;
			}
			if(w.getNumber()==1) {
				tree.setLeft(recursiveTree());
			}
			if(w.getNumber()==2) {
				tree.setLeft(recursiveTree());
				tree.setRight(recursiveTree());
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

	public ASTNode getAST() {
		return root;
	}
	
	public Word[] getWordsWithSpaces(String s) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
			System.out.println(commandList[k]);
			Word word = new Word(commandList[k], rb, CommandNumbers);
			sentence[k] = word;
		}
		return sentence;
	}
	
//	public static void main (String args[]) {
//		String s = "34";
//		Word w = new Word(s);
//	}
	
}

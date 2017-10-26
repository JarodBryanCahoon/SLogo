package backend.interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	public static final String CLASS_LIST = "resources/ClassList.txt";
	private ASTNode root;
	private String commands;
	private Map<String, ArrayList<Object>> myMap;
	private Map<String, Integer> CommandNumbers;
	private ResourceBundle rb;
	private Queue<Word> queue;
	
//	lasia made this temp constructor
	public TextParse() {
	}
	
	public TextParse(String s, Map<String, ArrayList<Object>> map, String filename) throws ClassNotFoundException, FileNotFoundException {
		commands = s;
		myMap = map;
		rb = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + filename);
		makeCommandNumbers();
		makeTree();
	}
	
	private void makeCommandNumbers() throws ClassNotFoundException, FileNotFoundException {
		CommandNumbers = new HashMap<String, Integer>();
		File fl = new File(CLASS_LIST);
		Scanner scan = new Scanner(fl);
		ArrayList<String> classList = new ArrayList<>();
		while(scan.hasNextLine()) {
			String st = scan.nextLine();
			classList.add(st);
			Class<?> c = Class.forName(st);
			Constructor[] cons = c.getConstructors();
			Method[] m = c.getDeclaredMethods();
			for(Constructor con : cons) {
				CommandNumbers.put(c.getName(), con.getParameterCount());
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
		fillCommandQueue(s);
		root = recursiveTree();
	}

	private void fillCommandQueue(String s) {
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
	}


	private ASTNode recursiveTree() {
		Word w = queue.poll();
		ASTNode tree = new ASTNode(w.getExpression());
		if(w.getType().equals("command")) {
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
	
//	Divides expression into Words, including spaces
//	Should be temporary - should find a way to incorporate it with
//	other methods to avoid duplicated code.
//probably don't need this? I've already divided stuff into words, including spaces, depending on when
//it needs to be changed -Venkat
	public Word[] lasiasmethod(String s) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
			Word word = new Word(commandList[k], rb, CommandNumbers);
			sentence[k] = word;
		}
		return sentence;
	}
	
}

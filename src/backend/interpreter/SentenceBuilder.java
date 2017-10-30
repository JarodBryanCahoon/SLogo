package backend.interpreter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import backend.board.TurtleCollection;

/**Creates an Array of Words from String
 * @author lasia lo
 *
 */
public class SentenceBuilder {
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private static final String DEFAULT_LANGUAGE_PACKAGE = "src/resources/languages/";
	private ResourceBundle myArguments;
	private Map<String,String> myLanguage;
	private Properties mySyntax;
	
	public SentenceBuilder(String language) {
		mySyntax = new SyntaxReader().getProperties();
		myArguments = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "ArgumentNumbers");
	}
	
	public void changeLanguage(Properties languageFile) { 
	    myLanguage = new HashMap<>(); 
	    for(Object key : languageFile.keySet()) { 
	      String s = key.toString(); 
	      String[] commands = languageFile.getProperty(s).split("\\|"); 
	      for(String command : commands) { 
	        myLanguage.put(command, s); 
	      } 
	    } 
	  }
	
	public Word[] getSentence(String s, TurtleCollection turtles) {
		System.out.println(s);
		String[] commandList = s.split(mySyntax.getProperty("WhiteSpace"));
		System.out.println(Arrays.toString(commandList));
		commandList = s.split("^#.");
		System.out.println(Arrays.toString(commandList));
		Word[] sentence = new Word[commandList.length];
		
		return null;
	}
	
	
	public Word[] getFormattedSentence(String s, TurtleCollection turtles) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
			Word word = new Word(commandList[k],myArguments, turtles, myLanguage);
			sentence[k] = word;
		}
		return sentence;
	}
}

package backend.interpreter;

import java.util.Properties;
import java.util.ResourceBundle;

import backend.board.TurtleCollection;

/**Creates an Array of Words from String
 * @author lasia lo
 *
 */
public class SentenceBuilder {
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private ResourceBundle myLanguage;
	private Properties mySyntax;
	
	public SentenceBuilder(String language) {
		myLanguage = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE+language);
		mySyntax = new SyntaxReader().getProperties();
	}
	
	public Word[] getSentence(String s, TurtleCollection turtles) {
		String[] commandList = s.split(mySyntax.getProperty("Whitespace"));
		return null;
	}
	
	public Word[] getFormattedSentence(String s, TurtleCollection turtles) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
//			System.out.println(commandList[k]);
			Word word = new Word(commandList[k], myLanguage, turtles);
			sentence[k] = word;
		}
		return sentence;
	}
}

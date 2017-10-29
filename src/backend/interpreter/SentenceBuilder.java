package backend.interpreter;

import java.util.ResourceBundle;

import backend.board.TurtleCollection;

/**Creates array of Words from String
 * @author lasia
 *
 */
public class SentenceBuilder {
	private ResourceBundle myLanguage;
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	
	public SentenceBuilder(String language) {
		myLanguage = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE+language);
		
	}
	public Word[] getSentence(String s, ) {
		
	}
	
	public Word[] getFormattedSentence(String s, TurtleCollection turtles) {
		String[] commandList = s.split("\\b");
		Word[] sentence = new Word[commandList.length];
		
		for (int k = 0; k< commandList.length; k++) {
//			System.out.println(commandList[k]);
			Word word = new Word(commandList[k], myLanguage, CommandNumbers, turtles);
			sentence[k] = word;
		}
		return sentence;
	}
}

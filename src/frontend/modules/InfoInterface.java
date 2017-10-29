package frontend.modules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import backend.interpreter.TextParse;
import backend.interpreter.Word;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**Acts as the interface between FrontEnd and Manager
 * Provides colored text of information
 * Should be Temporary
 * @author lasia lo
 *
 */

public class InfoInterface extends Observable {
	private List<Word[]> history;
	private TextParse parser;
	public InfoInterface() throws ClassNotFoundException, FileNotFoundException {
		history = new ArrayList<Word[]>();
		parser = new TextParse();
		
	}
//	
//	public void addToHistory(String inputText) {
//		Word[] sentence = parser.getWordsWithSpaces(inputText);
//		history.add(sentence);
//		setChanged();
//		notifyObservers();
//	}
	
	public FlowPane getHistory() {
		int index = history.size();
		Text indexText = new Text(Integer.toString(index) + "  ");
		TextFlow historyText = createSentence(history.get(index-1));
		FlowPane toReturn = new FlowPane();
		
		indexText.getStyleClass().add("Text");
		toReturn.getChildren().add(indexText);
		toReturn.getChildren().add(historyText);
	
		return toReturn;
	}
	
	private TextFlow createSentence(Word[] words) {
		TextFlow toReturn = new TextFlow();
		for (Word w : words) {
			Text text = new Text(w.getName());
			System.out.println(w.getType());
			text.getStyleClass().add(w.getType());
			toReturn.getChildren().add(text);
		}
		return toReturn;
	}

	public TextFlow[] getConsole(String test) {
		String lines[] = test.split("\\r?\\n");
		TextFlow[] toReturn = new TextFlow[lines.length];
		for (int k = 0; k<lines.length;k++) {
			Word[] sentence = parser.getWordsWithSpaces(lines[k]);
			TextFlow textFlow = createSentence(sentence);
			formatConsole(k,textFlow);
			toReturn[k] = textFlow;
		}
		return toReturn;
		
	}

	
	private void formatConsole(int k, TextFlow textFlow) {
		double fontHeight = textFlow.getChildren().get(0).getLayoutBounds().getHeight();
		textFlow.setLayoutX(10);
		textFlow.setLayoutY(k*(fontHeight + 5)+5);
		textFlow.getStyleClass().add("Window");
	}
}

package frontend.modules;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

import backend.board.TurtleCollection;
import backend.interpreter.History;
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
	private TextParse parser;
	private History myHistory;
	public InfoInterface(History history) throws ClassNotFoundException, FileNotFoundException {
		parser = new TextParse();
		myHistory = history;
	}
	
	public FlowPane getHistory() {
		Stack<Word[]> stackHistory = myHistory.getStackHistory();
		int index = stackHistory.size();
		Text indexText = new Text(Integer.toString(index) + "  ");
		TextFlow historyText = createSentence(stackHistory.peek());
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
			text.getStyleClass().add(w.getType());
			toReturn.getChildren().add(text);
		}
		return toReturn;
	}

	public TextFlow[] getConsole(String test, TurtleCollection turtles) {
		String lines[] = test.split("\\r?\\n");
		TextFlow[] toReturn = new TextFlow[lines.length];
		for (int k = 0; k<lines.length;k++) {
			Word[] sentence = parser.getFormattedSentence(lines[k], turtles);
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

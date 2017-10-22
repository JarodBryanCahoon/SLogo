package frontend.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**Acts as the interface between Console and Manager
 * Provides colored text of information
 * Temporary
 * @author lasia lo
 *
 */

public class InfoFactory extends Observable {
	private List<String> history;
	
	public InfoFactory() {
		history = new ArrayList<String>();
		
	}
	
	public void addToHistory(String inputText) {
		history.add(inputText);
		setChanged();
		notifyObservers();
	}
	public FlowPane getHistory() {
		int index = history.size();
		Text indexText = new Text(Integer.toString(index));
		Text n = new Text(history.get(index-1));
		
		FlowPane toReturn = new FlowPane();
		toReturn.getStyleClass().add("odd");
		indexText.getStyleClass().add("odd");
		n.getStyleClass().add("odd");
		if (index%2==0) {
			toReturn.getStyleClass().add("even");
			indexText.getStyleClass().add("even");
			n.getStyleClass().add("even");
		}
		toReturn.getChildren().add(indexText);
		toReturn.getChildren().add(n);
	
			
		
		return toReturn;
	}
	public TextFlow[] getConsole(String test) {
		String lines[] = test.split("\\r?\\n");
		TextFlow[] toReturn = new TextFlow[lines.length];
		for (int k = 0; k<lines.length;k++) {
			Text text = new Text(lines[k]);
			double fontHeight = text.getLayoutBounds().getHeight();
			text.getStyleClass().add("text");
			if (lines[k].contains("s"))
				text.getStyleClass().add("invalid");
			TextFlow textFlow = createText(k, text, fontHeight);
			toReturn[k] = textFlow;
		}
		
		
		return toReturn;
		
	}

	
	private TextFlow createText(int k, Text text, double fontHeight) {
		TextFlow textFlow = new TextFlow();
		textFlow.getChildren().add(text);
		textFlow.setLayoutX(10);
		textFlow.setLayoutY(k*(fontHeight + 5)+5);
		textFlow.getStyleClass().add("syntaxField");
		return textFlow;
	}
}

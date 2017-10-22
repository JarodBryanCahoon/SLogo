package frontend.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**Acts as the interface between Console and Manager
 * @author lasia
 *
 */

public class InterpreterInterface extends Observable {
	private List<String> history;
	
	public InterpreterInterface() {
		history = new ArrayList<String>();
		
	}
	
	public void addToHistory(String inputText) {
		history.add(inputText);
		
		setChanged();
		notifyObservers();
	}
	public String getHistory() {
		return history.get(history.size()-1);
	}
	
}

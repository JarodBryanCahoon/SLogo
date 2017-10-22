package frontend.modules;

import java.util.ArrayList;
import java.util.List;

/**Acts as the interface between Console and Manager
 * @author lasia
 *
 */

public class InterpreterInterface {
	private List<String> history;
	
	public InterpreterInterface() {
		history = new ArrayList<String>();
		
	}
	
	public void addToHistory(String inputText) {
		history.add(inputText);
	}
	public String getHistory() {
		return history.get(history.size());
	}
	
}

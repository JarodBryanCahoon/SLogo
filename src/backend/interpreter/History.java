package backend.interpreter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import backend.board.TurtleCollection;

/**
 * A Class that maintains a history of previous commands
 * @author Albert
 *
 */
public class History {
	private List<Word[]> myHistoryList;

	/**
	 * Creates a new History
	 */
	public History() {
		myHistoryList = new ArrayList<>();
	}
	
	/**
	 * Add a new Word[] to history
	 * @param commands	command history to be added
	 */
	protected void add(Word[] commands) {
		myHistoryList.add(commands);
	}
	
	/**
	 * @return	the command queue as a stack
	 */
	public Stack<Word[]> getStackHistory() {
		Stack<Word[]> myStackHistory = new Stack<>();
		for(Word[] words : myHistoryList) {
			myStackHistory.add(words);
		}
		return myStackHistory;
	}
	
	/**
	 * @return	the command history as a queue
	 */
	public Queue<Word[]> getQueueHistory() {
		Queue<Word[]> myQueueHistory = new LinkedList<>();
		for(Word[] s : myHistoryList) {
			myQueueHistory.add(s);
		}
		return myQueueHistory;
	}
}

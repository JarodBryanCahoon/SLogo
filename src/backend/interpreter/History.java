package backend.interpreter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class History {
	private List<Word[]> myHistoryList;
	public History() {
		myHistoryList = new ArrayList<>();
	}
	
	public void add(Word[] commands) {
		myHistoryList.add(commands);
	}
	
	public Stack<Word[]> getStackHistory() {
		Stack<Word[]> myStackHistory = new Stack<>();
		for(Word[] words : myHistoryList) {
			myStackHistory.add(words);
		}
		return myStackHistory;
	}
	
	public Queue<Word[]> getQueueHistory() {
		Queue<Word[]> myQueueHistory = new LinkedList<>();
		for(Word[] s : myHistoryList) {
			myQueueHistory.add(s);
		}
		return myQueueHistory;
	}
}

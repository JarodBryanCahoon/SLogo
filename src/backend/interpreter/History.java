package backend.interpreter;

import java.util.ArrayList;
import java.util.List;

public class History {
	List<String> myHistory;
	public History() {
		myHistory = new ArrayList<>();
	}
	
	public void add(String text) {
		myHistory.add(text);
	}
}

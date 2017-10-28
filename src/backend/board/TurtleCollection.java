package backend.board;

import java.util.ArrayList;
import java.util.List;

import backend.board.interfacemovement.TurtleNode;

public class TurtleCollection implements ITurtle {
	private List<Turtle> myTurtles;
	public TurtleCollection(List<Turtle> turtles) {
		myTurtles = turtles;
	}

	@Override
	public double act(TurtleNode m) {
		double returnValue = 0;
		for(Turtle turtle : getSelectedTurtles()) {
			returnValue = turtle.act(m);			
		}
		return returnValue;
	}
	
	private List<Turtle> getSelectedTurtles() {
		List<Turtle> selectedTurtles = new ArrayList<>();
		for(Turtle t : myTurtles) {
			if(t.isSelected()) {
				selectedTurtles.add(t);
			}
		}
		
		return selectedTurtles;
	}

}

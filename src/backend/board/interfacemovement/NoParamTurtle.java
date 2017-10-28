package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
import backend.board.TurtleCollection;

public abstract class NoParamTurtle extends TurtleNode{
	private int myChildNumber = 0;
	private List<Turtle> myTurtleList;
	
	public NoParamTurtle(TurtleCollection turtles) {
		super(turtles);
	}

	
	public int getChildNumber() {
		return myChildNumber;
	}
}

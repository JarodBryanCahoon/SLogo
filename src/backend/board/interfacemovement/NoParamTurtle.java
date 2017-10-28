package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;

public class NoParamTurtle extends TurtleGrandClass{
	private int myChildNumber = 0;
	private List<Turtle> myTurtleList;
	
	public NoParamTurtle(List<Turtle> l) {
		super(l);
	}

	
	public int getChildNumber() {
		return myChildNumber;
	}


}

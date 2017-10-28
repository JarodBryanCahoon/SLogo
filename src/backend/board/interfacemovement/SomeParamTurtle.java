package backend.board.interfacemovement;

import java.util.ArrayList;
import java.util.List;

import backend.board.Turtle;

public class SomeParamTurtle extends TurtleGrandClass{
	private List<Turtle> myTurtleList;
	private List<Node> myNodeList;
	
	public SomeParamTurtle(List<Turtle> l) {
		super(l);
		myNodeList = new ArrayList<>();
	}

	public List<Node> getChildren(){
		return myNodeList;
	}
}

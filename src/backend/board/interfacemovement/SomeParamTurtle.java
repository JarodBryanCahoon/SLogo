package backend.board.interfacemovement;

import java.util.ArrayList;
import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;

public abstract class SomeParamTurtle extends TurtleNode{
	private List<Turtle> myTurtleList;
	private List<ASTNode> myNodeList;
	
	public SomeParamTurtle(TurtleCollection turtles) {
		super(turtles);
		myNodeList = new ArrayList<>();
	}
}

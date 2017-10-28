package backend.board.interfacemovement;

import java.util.ArrayList;
import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;

public class SomeParamTurtle extends TurtleNode{
	private List<Turtle> myTurtleList;
	private List<ASTNode> myNodeList;
	
	public SomeParamTurtle(List<Turtle> turtles) {
		super(turtles);
		myNodeList = new ArrayList<>();
	}
	@Override
	public void setChildren(ASTNode n){
		
	}
}

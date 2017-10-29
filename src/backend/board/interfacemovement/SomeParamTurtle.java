package backend.board.interfacemovement;

import java.util.ArrayList;
import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.TurtleCollection;

public abstract class SomeParamTurtle extends TurtleNode{
	private List<ASTNode> myChildren;
	public SomeParamTurtle(TurtleCollection turtles) {
		super(turtles);
		myChildren = new ArrayList<>();
	}
	
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
	
	protected List<ASTNode> getChildren() {
		return myChildren;
	}
}

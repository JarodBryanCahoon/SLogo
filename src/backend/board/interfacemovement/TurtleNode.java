package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;

public class TurtleNode implements ASTNode {
	
	private List<Turtle> myTurtleList;
	
	public TurtleNode(List<Turtle> l) {
		myTurtleList = l;
	}
	
	public double act(Turtle turt) {
		return 0;
	}
	
	@Override
	public double execute() {
		double d = 0;
		for(Turtle t : myTurtleList) {
			d = this.act(t);
		}
		return d;
	}

	@Override
	public void setChildren(ASTNode n) {
		// TODO Auto-generated method stub
	}

}

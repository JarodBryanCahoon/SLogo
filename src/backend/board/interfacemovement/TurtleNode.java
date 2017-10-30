package backend.board.interfacemovement;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;

/**
 * @author Albert, Venkat
 *
 */
public abstract class TurtleNode implements ASTNode {
	
	private TurtleCollection myTurtles;
	
	public TurtleNode(TurtleCollection turtles) {
		myTurtles = turtles;
	}
	
	protected TurtleCollection getTurtles() {
		return myTurtles;		
	}
	
	public abstract double act(Turtle turt);
	
	@Override
	public double execute() {
		return myTurtles.act(this);
	}

	@Override
	public void setChildren(ASTNode n) {
		
	}
}

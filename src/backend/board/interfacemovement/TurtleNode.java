package backend.board.interfacemovement;

import java.io.IOException;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import exceptions.ErrorMessage;

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
	
	public abstract double act(Turtle turt) throws IOException;
	
	@Override
	public double execute() {
		try {
			return myTurtles.act(this);
		} catch (IOException e) {
			ErrorMessage eMessage = new ErrorMessage("Could not execute command!");
			eMessage.show();
		}
	}

	@Override
	public void setChildren(ASTNode n) {
		
	}
}

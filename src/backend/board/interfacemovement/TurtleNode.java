package backend.board.interfacemovement;

import java.io.IOException;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import exceptions.ErrorMessage;

/**
 * A class that provides a template for extending Nodes that perform actions on turtles
 * 
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
	
	/**
	 * Implements the logic for acting the command out on the turtle
	 * @param turt	turtle to act on
	 * @return		double value of the logo command execute
	 * @throws IOException
	 */
	public abstract double act(Turtle turt) throws IOException;
	
	@Override
	public double execute() {
		try {
			return myTurtles.act(this);		
		} catch(IOException e) {
			ErrorMessage eMessage = new ErrorMessage("Could not recognize command!");
			eMessage.show();
			return 0;
		}
	}

	@Override
	public void setChildren(ASTNode n) {
		
	}
}

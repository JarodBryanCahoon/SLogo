package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class ForwardLineMovement extends LineMovement {
	double myDistance;
	private List<ASTNode> myChildren;
	private List<Turtle> myTurtList;
	
	public ForwardLineMovement(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, myDistance, co);
	}
}

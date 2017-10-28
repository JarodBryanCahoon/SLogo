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
public class BackwardsLineMovement extends LineMovement {
	double myDistance;
	private List<Turtle> myTurtList;
	private List<ASTNode> myChildren;
	
	public BackwardsLineMovement(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, myDistance, co);
	}
}

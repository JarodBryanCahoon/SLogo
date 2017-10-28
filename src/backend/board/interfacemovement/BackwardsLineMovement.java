package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class BackwardsLineMovement extends LineMovement {
	double myDistance;
	private List<Turtle> myTurtList;
	private List<Node> myChildren;
	
	public BackwardsLineMovement(List<Turtle> l ) {
		super(l);
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, myDistance, co);
	}
	
	@Override
	public void setChildren(Node n) {
		myChildren.add(n);
	}
}

package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class ForwardLineMovement extends LineMovement {
	double myDistance;
	private List<ASTNode> myChildren;
	private List<Turtle> myTurtList;
	
	public ForwardLineMovement(List<Turtle> l ) {
		super(l);
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, myDistance, co);
	}
	
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
	
}

package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class LeftTurn extends SomeParamTurtle{
	private List<Turtle> myTurtleList;
	private List<ASTNode> myChildren;
	
	public LeftTurn(List<Turtle> l) {
		super(l);
	}
	
	@Override
	public double act(Turtle co) {
		double angle = myChildren.get(0).execute();
		co.getAngle().set((co.getAngle().get()+angle)%360);
		return angle;
	}
	
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}

}

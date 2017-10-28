package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetAngle extends SomeParamTurtle{
	private List<Turtle> myTurtleList;
	private List<ASTNode> myChildren;
	
	public SetAngle(List<Turtle> l) {
		super(l);
	}
	@Override
	public double act(Turtle co) {
		double angle = myChildren.get(0).execute();
		double returnAngle = angleDifference(angle, co.getAngle().get());
		co.getAngle().set(angle);
		return returnAngle;
	}

	private double angleDifference(double angle1, double angle2) {
		return (Math.abs(angle1-angle2) > 180) ? Math.abs(angle1-angle2)-180 : Math.abs(angle1-angle2);
	}
	
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
	
}

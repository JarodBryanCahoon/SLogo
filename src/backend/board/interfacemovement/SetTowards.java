package backend.board.interfacemovement;

import java.util.List;

import backend.Utilities.vectors.Vector;
import backend.Utilities.vectors.VectorMath;
import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetTowards extends SomeParamTurtle {
	private List<Turtle> myTurtleList;
	private List<ASTNode> myChildren;

	public SetTowards(List<Turtle> l) {
		super(l);
	}

	public double act(Turtle co) {
		double newAngle = VectorMath.angleBetweenXAxis(new Vector(myChildren.get(0).execute(), myChildren.get(1).execute()));
		double angleDiff = this.angleDifference(newAngle, co.getAngle().get());
		co.getAngle().set(newAngle);
		return angleDiff;
	}

	protected double angleDifference(double angle1, double angle2) {
		return (Math.abs(angle1 - angle2) > 180) ? Math.abs(angle1 - angle2) - 180 : Math.abs(angle1 - angle2);
	}
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
}

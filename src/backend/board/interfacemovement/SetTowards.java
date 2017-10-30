package backend.board.interfacemovement;

import java.util.List;

import backend.Utilities.vectors.Vector;
import backend.Utilities.vectors.VectorMath;
import backend.abstractsyntaxtree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetTowards extends SomeParamTurtle {
	public SetTowards(TurtleCollection turtles) {
		super(turtles);
	}

	public double act(Turtle co) {
		double newAngle = VectorMath.angleBetweenXAxis(new Vector(super.getChildren().get(0).execute(), super.getChildren().get(1).execute()));
		double angleDiff = this.angleDifference(newAngle, co.getAngle());
		co.setAngle(newAngle);
		return angleDiff;
	}

	protected double angleDifference(double angle1, double angle2) {
		return (Math.abs(angle1 - angle2) > 180) ? Math.abs(angle1 - angle2) - 180 : Math.abs(angle1 - angle2);
	}
}

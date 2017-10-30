package backend.board.interfacemovement;

import java.util.List;

import backend.abstractsyntaxtree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetAngle extends SomeParamTurtle {
	public SetAngle(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle co) {
		double angle = super.getChildren().get(0).execute();
		double returnAngle = angleDifference(angle, co.getAngle());
		co.setAngle(angle);
		return returnAngle;
	}

	private double angleDifference(double angle1, double angle2) {
		return (Math.abs(angle1 - angle2) > 180) ? Math.abs(angle1 - angle2) - 180 : Math.abs(angle1 - angle2);
	}
}

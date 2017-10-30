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
public class LeftTurn extends SomeParamTurtle {
	public LeftTurn(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle co) {
		double angle = super.getChildren().get(0).execute();
		co.setAngle((co.getAngle() + angle) % 360);
		return angle;
	}
}

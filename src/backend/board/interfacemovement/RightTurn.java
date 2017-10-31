package backend.board.interfacemovement;

import java.io.IOException;
import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class RightTurn extends SomeParamTurtle {
	public RightTurn(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		double angle = super.getChildren().get(0).execute();
		co.setAngle((co.getAngle() - angle < 0) ? (360 + (co.getAngle() - angle)): co.getAngle() - angle);
		return angle;
	}
}

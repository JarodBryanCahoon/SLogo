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
public class RightTurn extends SomeParamTurtle {
	public RightTurn(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		double angle = super.getChildren().get(0).execute();
		int modulo = (int) Math.abs(angle / 360 + 1);			
		double holder = 360 - angle;
		holder += ( 360 * modulo ) % 360;
		co.setAngle(holder);
		return angle;
	}
}

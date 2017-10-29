package backend.board.interfacemovement;

import java.util.List;

import backend.board.BoardMath;
import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetHome extends NoParamTurtle{
	public SetHome(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle co) {
		double distance = BoardMath.pointDistance(0, 0, co.getMyX(), co.getMyY());
		co.setX(0);
		co.setY(0);
		return distance;
	}
}

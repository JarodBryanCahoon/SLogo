package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.BoardMath;
import backend.board.Turtle;
import backend.board.TurtleCollection;

/**
 * @author Albert
 *	Implements the clear screen command
 */
public class ClearScreen extends NoParamTurtle {
	/**
	 * Creates a new ClearScreen Node
	 * @param turtles	TurtleCollection to iterate over
	 */
	public ClearScreen(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) throws IOException {
		double distance = BoardMath.pointDistance(0, 0, turt.getMyX(), turt.getMyY());
		turt.setClearScreen(true);
		turt.setX(Turtle.STARTING_POSITION[0]);
		turt.setY(Turtle.STARTING_POSITION[1]);
		return distance;
	}

}

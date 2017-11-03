package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.Turtle;
import backend.board.TurtleCollection;

/**
 * Implements the Id Command
 * 
 * @author Albert
 * 
 */
public class ID extends NoParamTurtle {

	/**
	 * Creates a new ID Command
	 * 
	 * @param turtles
	 */
	public ID(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) throws IOException {
		return turt.getId();
	}

}

package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenDown extends NoParamTurtle{	
	public PenDown(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 1;
	}
}

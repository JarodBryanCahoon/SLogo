package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Hide extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	
	public Hide(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(false);
		return 0;
	}
}

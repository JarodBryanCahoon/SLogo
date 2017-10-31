package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Show extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	
	public Show(TurtleCollection l) {
		super(l);
	}
	@Override
	public double act(Turtle co) {
		co.setOpacity(true);
		return 1;
	}

	
}
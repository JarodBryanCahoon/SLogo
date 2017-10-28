package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenUp extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	
	public PenUp(List<Turtle> l) {
		super(l);
	}

	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 0;
	}


}

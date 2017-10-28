package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenDown extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	
	public PenDown(List<Turtle> l) {
		super(l);
	}

	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 1;
	}

}

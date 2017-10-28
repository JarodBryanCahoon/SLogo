package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Hide extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	
	public Hide(List<Turtle> l) {
		super(l);
	}
	
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(false);
		return 0;
	}
	
	@Override
	public double execute() {
		return 0;
	}

}

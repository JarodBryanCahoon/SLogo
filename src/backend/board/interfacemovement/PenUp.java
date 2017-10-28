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

	
	public double execute() {
		double num = 0;
		for (Turtle t: myTurtleList) {
			num=act(t);
		}
		return num;
	}
	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 0;
	}


}

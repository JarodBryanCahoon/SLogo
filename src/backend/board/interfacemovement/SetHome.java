package backend.board.interfacemovement;

import java.util.List;

import backend.board.BoardMath;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetHome extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	
	public SetHome(List<Turtle> l) {
		super(l);
	}

	@Override
	public double act(Turtle co) {
		double distance = BoardMath.pointDistance(0, 0, co.getMyX().get(), co.getMyY().get());
		co.getMyX().set(0);
		co.getMyY().set(0);
		return distance;
	}
	

}

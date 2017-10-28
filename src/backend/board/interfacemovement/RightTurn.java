package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class RightTurn extends SomeParamTurtle {
	private List<Turtle> myTurtleList;
	private List<Node> myChildren;
	
	public RightTurn(List<Turtle> l) {
		super(l);
	}
	
	@Override
	public double act(Turtle co) {
		double angle = myChildren.get(0).execute();
		int modulo = (int) Math.abs(angle / 360 + 1);			
		double holder = 360 - angle;
		holder += ( 360 * modulo ) % 360;
		co.getAngle().set(holder);
		return angle;
	}

}

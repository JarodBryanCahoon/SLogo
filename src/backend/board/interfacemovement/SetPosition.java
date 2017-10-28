package backend.board.interfacemovement;

import java.util.List;

import backend.board.BoardMath;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetPosition extends SomeParamTurtle{
	private List<Turtle> myTurtleList;
	private List<Node> myChildren;
	
	public SetPosition(List<Turtle> l) {
		super(l);
	}
	@Override
	public double act(Turtle co) {
		double xMove = myChildren.get(0).execute(); // These are hard coded but can be remove later
		double yMove = myChildren.get(1).execute(); 
		double diff = BoardMath.pointDistance(xMove, yMove, co.getMyX().get(), co.getMyY().get());
		co.getMyX().set(xMove);
		co.getMyY().set(yMove);
		return diff;
	}
	
	@Override
	public void setChildren(Node n) {
		myChildren.add(n);
	}
	

}

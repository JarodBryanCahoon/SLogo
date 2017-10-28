package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class RightTurn extends SomeParamTurtle {
	private List<Turtle> myTurtleList;
	private List<ASTNode> myChildren;
	
	public RightTurn(TurtleCollection turtles) {
		super(turtles);
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

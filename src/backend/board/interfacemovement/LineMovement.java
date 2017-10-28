package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.BoardMath;
import backend.board.Turtle;
import backend.board.TurtleCollection;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class LineMovement extends SomeParamTurtle{
	private List<Turtle> myTurtleList;
	private List<ASTNode> myChildren;
	
	public LineMovement(TurtleCollection turtles) {
		super(turtles);
	}
	
	protected double move(boolean b, double pixels, Turtle turt){
		double[] delta = BoardMath.xyDeltaCalc(pixels, turt.getAngle().get());
		double xHold = turt.getMyX().get();
		double yHold = turt.getMyY().get();
		xHold += b? delta[0]: -delta[0];
		yHold += b? delta[1]: -delta[1];
		turt.getMyX().set(xHold);
		turt.getMyY().set(yHold);
		
		return pixels;
	}

	@Override
	public double act(Turtle co) {
		return 0;
	}
}

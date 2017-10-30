package backend.board.interfacemovement;

import java.util.List;

import backend.abstractsyntaxtree.ASTNode;
import backend.board.BoardMath;
import backend.board.Turtle;
import backend.board.TurtleCollection;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public abstract class LineMovement extends SomeParamTurtle{	
	public LineMovement(TurtleCollection turtles) {
		super(turtles);
	}
	
	protected double move(boolean b, double pixels, Turtle turt){

		double[] delta = BoardMath.xyDeltaCalc(pixels, turt.getAngle());
		double xHold = turt.getMyX();
		double yHold = turt.getMyY();
		xHold += b? delta[0]: -delta[0];
		yHold += b? delta[1]: -delta[1];
		turt.setX(xHold);
		turt.setY(yHold);

		return pixels;
	}
}

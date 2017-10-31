package backend.board.interfacemovement;

import java.io.IOException;
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
public class SetPosition extends SomeParamTurtle{
	public SetPosition(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		double xMove =super.getChildren().get(0).execute(); // These are hard coded but can be remove later
		double yMove = super.getChildren().get(1).execute(); 
		double diff = BoardMath.pointDistance(xMove, yMove, co.getMyX(), co.getMyY());
		co.setX(xMove);
		co.setY(yMove);
		return diff;
	}
}

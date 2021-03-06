package backend.board.interfacemovement;

import java.io.IOException;
import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class ForwardLineMovement extends LineMovement {	
	public ForwardLineMovement(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, super.getChildren().get(0).execute(), co);
	}
}

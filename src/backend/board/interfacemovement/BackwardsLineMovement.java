package backend.board.interfacemovement;

import java.util.List;

import backend.abstractsyntaxtree.ASTNode;
import backend.board.Turtle;
import backend.board.TurtleCollection;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class BackwardsLineMovement extends LineMovement {
	public BackwardsLineMovement(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(false, super.getChildren().get(0).execute(), co);
	}
}

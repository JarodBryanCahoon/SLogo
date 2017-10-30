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
public class Show extends NoParamTurtle{
	public Show(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		co.setOpacity(true);
		return 1;
	}
}
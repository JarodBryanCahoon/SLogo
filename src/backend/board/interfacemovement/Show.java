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
public class Show extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	private List<ASTNode> myChildren;
	
	public Show(TurtleCollection turtles) {
		super(turtles);
	}
	
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(true);
		return 1;
	}
}
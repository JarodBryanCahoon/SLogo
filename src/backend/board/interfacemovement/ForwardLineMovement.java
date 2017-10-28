package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class ForwardLineMovement extends LineMovement {
	double myDistance;
	public ASTNode myChild;
	private List<Turtle> myTurtList;
	
	public ForwardLineMovement(List<Turtle> l ) {
		myTurtList = l;
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, myDistance, co);
	}
	
	public double execute() {
		double value = 0;
		for(Turtle t : myTurtList) {
			//value = this.move(true, myChild.execute(), t);
		}
		return value;
	}
	
}

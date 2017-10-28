package backend.board.interfacemovement;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Show extends NoParamTurtle{
	private List<Turtle> myTurtleList;
	private List<ASTNode> myChildren;
	
	public Show(List<Turtle> l) {
		super(l);
	}
	@Override
	public double act(Turtle co) {
		co.getOpacity().set(true);
		return 1;
	}
	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
	

}
package backend.control;

import java.util.ArrayList;
import java.util.List;

import backend.abstractSyntaxTree.ASTNode;

public class ControlNode implements ASTNode{
	private List<ASTNode> myChildren;
	public ControlNode() {
		myChildren = new ArrayList<>();
	}

	@Override
	public double execute() {
		return 0;
	}

	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
	
	
	protected List<ASTNode> getChildren(){
		return myChildren;
	}

}

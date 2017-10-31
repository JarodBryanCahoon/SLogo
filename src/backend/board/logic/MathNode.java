package backend.board.logic;

import java.util.ArrayList;
import java.util.List;

import backend.abstractSyntaxTree.ASTNode;

public class MathNode implements ASTNode{
	private List<ASTNode> myChildren;
	
	public MathNode() {
		myChildren = new ArrayList<>();
	}
	@Override
	public double execute() {
		return 0;
	}

	@Override
	public void setChildren(ASTNode n) {
		System.out.println("Children");
		myChildren.add(n);
	}

	protected List<ASTNode> getChildren() {
		return myChildren;
	}
}

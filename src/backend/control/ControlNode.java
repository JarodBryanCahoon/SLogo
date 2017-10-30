package backend.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;

public class ControlNode implements ASTNode{
	private List<ASTNode> myChildren;
	private Map<String, VariableNode> variables;
	
	public ControlNode(Map<String, VariableNode> variable) {
		myChildren = new ArrayList<>();
		variables = variable;
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
	
	protected Map<String, VariableNode> getVariables(){
		return variables;
	}

}

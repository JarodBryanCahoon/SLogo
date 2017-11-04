package backend.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;
/*
 * @author Venkat Subramaniam
 * This class is the super class for all nodes related to the control commands, such as for loops or if statements.
 */
public class ControlNode implements ASTNode{
	private List<ASTNode> myChildren;
	private Map<String, VariableNode> variables;
	
	/*
	 * The constructor initializes a list of children nodes and takes in a map of variables.
	 * @param variable
	 */
	public ControlNode(Map<String, VariableNode> variable) {
		myChildren = new ArrayList<>();
		variables = variable;
	}

	/*
	 * (non-Javadoc)
	 * @see backend.abstractSyntaxTree.ASTNode#execute()
	 */
	@Override
	public double execute() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see backend.abstractSyntaxTree.ASTNode#setChildren(backend.abstractSyntaxTree.ASTNode)
	 */
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
	
	/*
	 * This command enables the subclasses to access a list of their children.
	 */
	protected List<ASTNode> getChildren(){
		return myChildren;
	}
	/*
	 * This command enables the subclasses to access the map of variables.
	 */
	protected Map<String, VariableNode> getVariables(){
		return variables;
	}

}

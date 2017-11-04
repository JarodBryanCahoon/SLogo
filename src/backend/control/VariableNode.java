package backend.control;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.logic.MathNode;
import backend.board.logic.NoParamMath;

/*
 * @author Venkat Subramaniam
 * This class allows users to create their own variables.
 */
public class VariableNode extends MathNode{
    private String myName;
	private double myValue=0;
	
	/*
	 * The constructor sets the name for the variable.
	 * @param s
	 */
	public VariableNode(String s) {
     myName = s;
	}

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override 
	public double execute() {
		return myValue;
		
	}
	
	/*
	 * This sets the value of the variable.
	 */
	public void setValue(double d) {
		myValue = d;
	}
	
	/*
	 * This is a public get method for the name of the variable.
	 */
	public String getName() {
		return myName;
	}

	/*
	 * This is a public method to determine if the variable is a number variable or a command variable.
	 */
	public boolean isNumberVar() {
		return true;
	}
	
	/*
	 * This creates a command variable given a ListNode and a number of arguments.
	 */
	public CommandVariableNode makeCommandNode(ListNode list, int args) {
	CommandVariableNode fun = new CommandVariableNode(myName, list, args);
		return fun;
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#setChildren(backend.abstractSyntaxTree.ASTNode)
	 */
	@Override
	public void setChildren(ASTNode n) {
		
	}
	
	
	
	
}

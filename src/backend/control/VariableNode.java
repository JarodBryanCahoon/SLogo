package backend.control;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.logic.MathNode;
import backend.board.logic.NoParamMath;

public class VariableNode extends MathNode{
    private String myName;
	private double myValue=0;
	
	public VariableNode(String s) {
     myName = s;
	}

	@Override 
	public double execute() {
		return myValue;
		
	}
	public void setValue(double d) {
		myValue = d;
	}
	
	public String getName() {
		return myName;
	}

	public boolean isNumberVar() {
		return true;
	}
	
	public CommandVariableNode makeCommandNode(ListNode list, int args) {
	CommandVariableNode fun = new CommandVariableNode(myName, list, args);
		return fun;
	}
	
	@Override
	public void setChildren(ASTNode n) {
		
	}
	
	
	
	
}

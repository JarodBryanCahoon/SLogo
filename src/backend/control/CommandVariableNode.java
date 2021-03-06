package backend.control;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;

public class CommandVariableNode extends VariableNode{
	private ListNode commands;
	private List<ASTNode> myChildren;
	private int args;
	public CommandVariableNode(String name, ListNode command, int arg) {
		super(name);
		commands = command;
		args = arg;
	}
	
	
	@Override
	public double execute() {
		return commands.execute();
	}


	
	@Override
	public boolean isNumberVar() {
		return false;
	}
	
	public int getArgNum() {
		return args;
	}
	
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
}

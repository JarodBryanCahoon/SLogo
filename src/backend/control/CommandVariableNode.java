package backend.control;

import java.util.List;

import backend.abstractSyntaxTree.ASTNode;

/*
 * @author Venkat Subramaniam
 * This class is the class which creates user-created commands.
 */

public class CommandVariableNode extends VariableNode{
	private ListNode commands;
	private List<ASTNode> myChildren;
	private int args;
	
	/*
	 * The constructor calls the super constructor, then sets the list of commands for the user created command
	 * and the number of arguments.
	 * @param name
	 * @param command
	 * @param arg
	 */
	public CommandVariableNode(String name, ListNode command, int arg) {
		super(name);
		commands = command;
		args = arg;
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.control.VariableNode#execute()
	 */
	@Override
	public double execute() {
		return commands.execute();
	}


	/*
	 * (non-Javadoc)
	 * @see backend.control.VariableNode#isNumberVar()
	 */
	@Override
	public boolean isNumberVar() {
		return false;
	}
	/*
	 * This is a public get method for the number of arguments that the command takes.
	 */
	public int getArgNum() {
		return args;
	}
	/*
	 * (non-Javadoc)
	 * @see backend.control.VariableNode#setChildren(backend.abstractSyntaxTree.ASTNode)
	 */
	@Override
	public void setChildren(ASTNode n) {
		myChildren.add(n);
	}
}

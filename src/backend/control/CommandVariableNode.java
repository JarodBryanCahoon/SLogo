package backend.control;

public class CommandVariableNode extends VariableNode{
	private ListNode commands;
	public CommandVariableNode(String name, ListNode command) {
		super(name);
		commands = command;
	}
	
	
	@Override
	public double execute() {
		return commands.execute();
	}


	public void setList(ListNode myList) {
		commands = myList;
	}

}

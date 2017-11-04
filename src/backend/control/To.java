package backend.control;

import java.util.Map;

public class To extends ControlNode {
	private CommandVariableNode command; 
	private double result = 0;
	public To(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	
	@Override
	public double execute() {
		makeCommandNode();
		makeVariables();
		return result;
	}
	

	private void makeVariables() {
		ListNode myList = (ListNode) super.getChildren().get(1);
		String[] vars = myList.getContents();
		
		for (int i = 0; i<vars.length; i++) {
			if (!super.getVariables().containsKey(vars[i])) {
				VariableNode var = new VariableNode(vars[i]);
				super.getVariables().put(vars[i], var);
				result = 1;
			}
		}	
	}


	private void makeCommandNode() {
		ListNode myList = (ListNode) super.getChildren().get(2);
		VariableNode var = (VariableNode) super.getChildren().get(0);
		ListNode myArgs = (ListNode) super.getChildren().get(1);
		String name = var.getName();
		command = super.getVariables().get(name).makeCommandNode(myList, myArgs.getContents().length);
		super.getVariables().put(command.getName(), command);
	}

}

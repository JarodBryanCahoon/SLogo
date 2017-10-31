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
		String name = var.getName();
//		if (!super.getVariables().containsKey(name)){
//			command = new CommandVariableNode(name, myList);
//			super.getVariables().put(name, command);
//		}
//		else {
		command = (CommandVariableNode) super.getVariables().get(name);
//		}
		command.setList(myList);
	}

}

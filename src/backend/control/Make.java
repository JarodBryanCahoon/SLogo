package backend.control;

import java.util.Map;

public class Make extends ControlNode {

	public Make(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	
	@Override
	public double execute() {
		VariableNode myVariable = (VariableNode) super.getChildren().get(0);
		myVariable.setValue(super.getChildren().get(1).execute());
		return myVariable.execute();	
	}

}

package backend.control;

import java.util.Map;

public class IfElse  extends ControlNode{

	public IfElse(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	@Override
	public double execute() {
		if (super.getChildren().get(0).execute()!=0) {
			return super.getChildren().get(1).execute();
		}
		return super.getChildren().get(2).execute();
	}
}

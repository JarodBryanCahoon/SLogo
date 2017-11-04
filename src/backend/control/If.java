package backend.control;

import java.util.Map;

public class If extends ControlNode{

	public If(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	@Override
	public double execute() {
		if (super.getChildren().get(0).execute()!=0) {
			return super.getChildren().get(1).execute();
		}
		return 0;
	}

}

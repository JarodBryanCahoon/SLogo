package backend.control;

import java.util.Map;

public class Repeat extends ControlNode {
	private static final String REPCOUNT = ":repCount";
	public Repeat(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	
	@Override
	public double execute() {
		double d=0;
		VariableNode repcount;
		if (!super.getVariables().containsKey(REPCOUNT)) {
			repcount = new VariableNode(REPCOUNT);
			super.getVariables().put(REPCOUNT, repcount);
		}
		else {
			repcount = super.getVariables().get(REPCOUNT);
		}
		
		for (double i=1; i<=super.getChildren().get(0).execute(); i++) {
			repcount.setValue(i);
			d = super.getChildren().get(1).execute();
		}
		
		return d;
	}
	
	
	

}

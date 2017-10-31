package backend.control;

import java.util.Map;

public class For extends ControlNode{
    private double limit = 0;
	private VariableNode count;
	private String[] params;
	private double init;
	private double increment;
	
	public For(Map<String, VariableNode> variables) {
		super(variables);
	}

	@Override
	public double execute() {
		makeVariable();
		double result= 0;
		for (double i = init ; i<=limit; i+=increment) {
			result = super.getChildren().get(1).execute();
		}
		return result;
	}
	
	private void makeVariable() {
		ListNode myList = (ListNode) super.getChildren().get(0);
		params = myList.getContents();
		limit = Double.parseDouble(params[2]);
		increment = Double.parseDouble(params[3]);
		init = Double.parseDouble(params[1]);
		if (!super.getVariables().containsKey(params[0])){
			count = new VariableNode(params[0]);
			super.getVariables().put(params[0], count);
		}
		else {
			count = super.getVariables().get(params[0]);
		}
		
		count.setValue(init);
	}
}

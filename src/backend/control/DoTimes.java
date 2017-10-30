package backend.control;

import java.util.Map;

public class DoTimes extends ControlNode{	
	private VariableNode count;
	private int limit;
	public DoTimes(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	@Override
	public double execute() {
		makeVariable();
		double result = 0;
		for (int i=1; i<=limit; i++) {
			count.setValue(i);
			result = super.getChildren().get(1).execute();
		}
		return result;
	}

	private void makeVariable() {
		ListNode myList = (ListNode) super.getChildren().get(0);
		String[] needsName = myList.getContents();
		limit = Integer.parseInt(needsName[1]);
		if (!super.getVariables().containsKey(needsName[0])){
			count = new VariableNode(needsName[0]);
			super.getVariables().put(needsName[0], count);
		}
		else {
			count = super.getVariables().get(needsName[0]);
		}
	}

}

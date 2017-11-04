package backend.control;

import java.util.Map;

/*
 * @author Venkat Subramaniam
 * This class creates a DoTimes node, which executes a command a certain number of times.
 */
public class DoTimes extends ControlNode{	
	private VariableNode count;
	private int limit;
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public DoTimes(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.control.ControlNode#execute()
	 */
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

	/*
	 * This command creates a variable, repcount, that can be accessed by the commands being performed.
	 */
	private void makeVariable() {
		ListNode myList = (ListNode) super.getChildren().get(0);
		String[] params = myList.getContents();
		limit = Integer.parseInt(params[1]);
		if (!super.getVariables().containsKey(params[0])){
			count = new VariableNode(params[0]);
			super.getVariables().put(params[0], count);
		}
		else {
			count = super.getVariables().get(params[0]);
		}
	}

}

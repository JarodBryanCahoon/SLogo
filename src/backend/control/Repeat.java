package backend.control;

import java.util.Map;

/*
 * This class enables one to repeat commands a certain number of times.
 */
public class Repeat extends ControlNode {
	private static final String REPCOUNT = ":repCount";
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public Repeat(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.control.ControlNode#execute()
	 */
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

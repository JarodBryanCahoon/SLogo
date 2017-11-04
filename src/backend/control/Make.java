package backend.control;

import java.util.Map;
/*
 * @author Venkat Subrmaniam
 * This class enables one to make their own variables.
 */
public class Make extends ControlNode {

	/*
	 * The constructor just calls the super constructor.
	 */
	public Make(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.control.ControlNode#execute()
	 */
	@Override
	public double execute() {
		VariableNode myVariable = (VariableNode) super.getChildren().get(0);
		myVariable.setValue(super.getChildren().get(1).execute());
		return myVariable.execute();	
	}

}

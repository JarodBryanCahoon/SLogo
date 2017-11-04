package backend.control;

import java.util.Map;

/*
 * @author Venkat Subramaniam
 * This class enables the creation of if statements.
 */
public class If extends ControlNode{

	/*
	 * The constructor just calls the super constructor.
	 */
	public If(Map<String, VariableNode> variables) {
		super(variables);
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.control.ControlNode#execute()
	 */
	@Override
	public double execute() {
		if (super.getChildren().get(0).execute()!=0) {
			return super.getChildren().get(1).execute();
		}
		return 0;
	}

}

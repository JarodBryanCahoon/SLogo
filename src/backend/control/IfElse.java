package backend.control;

import java.util.Map;

/*
 * @author Venkat Subramaniam
 * This class just enables the creation of if-else statements.
 */
public class IfElse  extends ControlNode{

	/*
	 * This constructor just calls the super constructor.
	 */
	public IfElse(Map<String, VariableNode> variables) {
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
		return super.getChildren().get(2).execute();
	}
}

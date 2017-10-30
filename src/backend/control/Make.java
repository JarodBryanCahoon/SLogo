package backend.control;

public class Make extends ControlNode {

	public Make() {
		super();
	}
	
	
	@Override
	public double execute() {
		VariableNode myVariable = (VariableNode) super.getChildren().get(0);
		myVariable.setValue(super.getChildren().get(1).execute());
		return myVariable.execute();	
	}

}

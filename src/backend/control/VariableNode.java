package backend.control;

import backend.board.logic.NoParamMath;

public class VariableNode extends NoParamMath{
    private String myName;
	private double myValue=0;
	public VariableNode(String s) {
     myName = s;
	}

	@Override 
	public double execute() {
		return myValue;
		
	}
	public void setValue(double d) {
		myValue = d;
	}
	
	public String getName() {
		return myName;
	}

	public boolean isNumberVar() {
		return true;
	}
}

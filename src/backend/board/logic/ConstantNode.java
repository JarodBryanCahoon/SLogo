package backend.board.logic;

public class ConstantNode extends NoParamMath{
	double myValue;
	public ConstantNode(double d) {
		myValue = d;
	}
	@Override
	public double execute() {
		return myValue;
	}
	
}

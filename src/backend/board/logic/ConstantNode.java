package backend.board.logic;

/*
 * @author Venkat Subramaniam
 * This class creates a constant node. 
 */
public class ConstantNode extends NoParamMath{
	double myValue;
	
	
	/*
	 * The constructor takes in a double d and sets it as its value.
	 * @param d
	 */
	public ConstantNode(double d) {
		myValue = d;
	}
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.NoParamMath#execute()
	 */
	@Override
	public double execute() {
		return myValue;
	}
	
}

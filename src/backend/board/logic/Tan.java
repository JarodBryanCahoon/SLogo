package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class creates  a Tan node.
 *
 */
public class Tan extends MathNode{
	
	/*
	 * The constructor just calls the super constructor
	 */
	public Tan() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		return Math.tan(Math.toDegrees(super.getChildren().get(0).execute()));
	}
}
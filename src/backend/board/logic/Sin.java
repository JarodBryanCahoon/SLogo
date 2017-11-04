package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class creates a Sin Node.
 */
public class Sin extends MathNode{

	/*
	 * The constructor just calls the super constructor.
	 */
	public Sin() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		 return Math.sin(Math.toDegrees(super.getChildren().get(0).execute()));
	}
}
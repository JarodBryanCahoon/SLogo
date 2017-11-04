package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramniam
 * This class just creates a not equal object.
 */
public class NotEqual extends MathNode{
	/*
	 * The constructor just calls the super constructor.
	 */
	public NotEqual() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return (myNumOne != myNumTwo) ? 1:0;
	}
}
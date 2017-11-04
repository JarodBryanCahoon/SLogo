package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class creates a power node.
 */
public class Pow extends MathNode{
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public Pow() {
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
		return Math.pow(myNumOne, myNumTwo);
	}
}
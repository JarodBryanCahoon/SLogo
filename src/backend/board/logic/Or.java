package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class creates an Or node.
 */
public class Or extends MathNode{
	/*
	 * This constructor just calls the super constructor.
	 */
	public Or() {
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
		return (myNumOne != 0 || myNumTwo != 0) ? 1:0;
	}
}
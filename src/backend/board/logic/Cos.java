package backend.board.logic;



/**
 * 
 * @author Jarod Cahoon, Venkat Subramniam
 *This class creates a Cos node.
 */
public class Cos extends MathNode{
	
	/*
	 * Constructor just calls the super constructor.
	 */
	public Cos() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		 return Math.cos(Math.toDegrees(super.getChildren().get(0).execute()));
	}

}
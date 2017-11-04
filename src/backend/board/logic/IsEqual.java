package backend.board.logic;

/*
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class IsEqual extends MathNode{
	public IsEqual() {
		super();
	}

	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return (myNumOne==myNumTwo) ? 1:0;
	}

}
package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Or extends MathNode{
	
	public Or() {
		super();
	}

	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return (myNumOne != 0 || myNumTwo != 0) ? 1:0;
	}
}
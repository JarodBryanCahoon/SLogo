package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Pow extends MathNode{
	
	public Pow() {
		super();
	}

	@Override
	public double execute() {
		double myNumOne = super.getChildren().get(0).execute();
		double myNumTwo = super.getChildren().get(1).execute();
		return Math.pow(myNumOne, myNumTwo);
	}
}
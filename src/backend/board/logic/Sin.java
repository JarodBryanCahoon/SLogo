package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Sin extends MathNode{

	public Sin() {
		super();
	}
	
	@Override
	public double execute() {
		 return Math.sin(Math.toDegrees(super.getChildren().get(0).execute()));
	}
}
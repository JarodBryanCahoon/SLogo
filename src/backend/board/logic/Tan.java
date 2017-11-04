package backend.board.logic;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Tan extends MathNode{
	
	public Tan() {
		super();
	}
	
	@Override
	public double execute() {
		return Math.tan(Math.toDegrees(super.getChildren().get(0).execute()));
	}
}
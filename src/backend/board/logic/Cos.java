package backend.board.logic;



/**
 * 
 * @author Jarod Cahoon, Venkat Subramniam
 *
 */
public class Cos extends MathNode{
	
	public Cos() {
		super();
	}

	@Override
	public double execute() {
		 return Math.cos(Math.toDegrees(super.getChildren().get(0).execute()));
	}

}
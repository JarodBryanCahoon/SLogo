package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 * This class creates a random Node.
 */
public class Random extends MathNode{
	
	/*
	 * The constructor just calls the super constructor.
	 */
	public Random() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see backend.board.logic.MathNode#execute()
	 */
	@Override
	public double execute() {
		 return ThreadLocalRandom.current().nextDouble(0, super.getChildren().get(0).execute() + 1);
	}
}
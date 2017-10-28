package backend.board.logic;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public class Random extends MathNode{
	public Random() {
		super();
	}
	
	@Override
	public double execute() {
		 return ThreadLocalRandom.current().nextDouble(0, super.getChildren().get(0).execute() + 1);
	}
}
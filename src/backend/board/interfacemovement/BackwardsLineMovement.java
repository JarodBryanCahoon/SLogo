package backend.board.interfacemovement;

import backend.board.Turtle;

public class BackwardsLineMovement extends LineMovement {
double myDistance;
	
	public BackwardsLineMovement(double b) {
		myDistance =  b;
	}
	
	@Override
	public double act(Turtle co) {
		return this.move(true, myDistance, co);
	}
	
}

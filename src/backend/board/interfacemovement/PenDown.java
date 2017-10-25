package backend.board.interfacemovement;

import backend.board.Turtle;

public class PenDown implements MoveInterface{
	
	public PenDown() {
		
	}

	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 1;
	}

}

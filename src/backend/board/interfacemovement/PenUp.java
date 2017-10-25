package backend.board.interfacemovement;

import backend.board.Turtle;

public class PenUp implements MoveInterface{
	
	public PenUp() {
		
	}

	@Override
	public double act(Turtle co) {
		co.getPen().set(false);
		return 0;
	}

}

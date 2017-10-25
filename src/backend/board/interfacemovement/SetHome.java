package backend.board.interfacemovement;

import backend.board.BoardMath;
import backend.board.Turtle;

public class SetHome implements MoveInterface{
	
	public SetHome() {
		
	}

	@Override
	public double act(Turtle co) {
		double distance = BoardMath.pointDistance(0, 0, co.getMyX().get(), co.getMyY().get());
		co.getMyX().set(0);
		co.getMyY().set(0);
		return distance;
	}
	

}

package backend.board.interfacemovement;

import backend.board.BoardMath;
import backend.board.Turtle;

public class SetPosition implements MoveInterface{
	private double xMove;
	private double yMove;
	
	public SetPosition(double x, double y) {
		xMove = x;
		yMove = y;
		
	}
	@Override
	public double act(Turtle co) {
		double diff = BoardMath.pointDistance(xMove, yMove, co.getMyX().get(), co.getMyY().get());
		co.getMyX().set(xMove);
		co.getMyY().set(yMove);
		return diff;
	}
	

}

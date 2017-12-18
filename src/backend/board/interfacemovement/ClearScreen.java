package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.BoardMath;
import backend.board.Turtle;
import backend.board.TurtleCollection;

public class ClearScreen extends NoParamTurtle {

	public ClearScreen(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) throws IOException {
		double distance = BoardMath.pointDistance(0, 0, turt.getMyX(), turt.getMyY());
		turt.setClearScreen(true);
		turt.setX(0);
		turt.setY(0);
		return distance;
	}

}

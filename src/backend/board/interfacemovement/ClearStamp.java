package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.Turtle;
import backend.board.TurtleCollection;

public class ClearStamp extends NoParamTurtle{

	public ClearStamp(TurtleCollection turtles) {
		super(turtles);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double act(Turtle turt) throws IOException {
		turt.clearStamps();
		return 0;
	}

}

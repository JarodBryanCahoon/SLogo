package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.Turtle;
import backend.board.TurtleCollection;

public class Stamp extends NoParamTurtle{

	public Stamp(TurtleCollection turtles) {
		super(turtles);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double act(Turtle turt) throws IOException {
		turt.placeStamp();
		return 1;
	}

}

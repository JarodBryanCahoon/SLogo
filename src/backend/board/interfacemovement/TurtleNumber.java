package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.Turtle;
import backend.board.TurtleCollection;

public class TurtleNumber extends NoParamTurtle {

	public TurtleNumber(TurtleCollection turtles) {
		super(turtles);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double act(Turtle turt) throws IOException {
		return (double) this.getTurtles().totalTurtlesAdded();
	}

}

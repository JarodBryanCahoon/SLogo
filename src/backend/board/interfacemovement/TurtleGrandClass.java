package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;

public class TurtleGrandClass implements Node {
	
	private List<Turtle> myTurtleList;
	
	public TurtleGrandClass(List<Turtle> l) {
		myTurtleList = l;
	}
	
	protected double act(Turtle turt) {
		return 0;
	}
	
	@Override
	public double execute() {
		double d = 0;
		for(Turtle t : myTurtleList) {
			d = this.act(t);
		}
		return d;
	}

	@Override
	public void setChildren(Node n) {
		// TODO Auto-generated method stub
	}

}

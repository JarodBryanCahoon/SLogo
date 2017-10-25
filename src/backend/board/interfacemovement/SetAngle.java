package backend.board.interfacemovement;

import backend.board.Turtle;

public class SetAngle extends AbsoluteMovement{
	private double myAngle;
	
	public SetAngle(double ang) {
		myAngle = ang;
		
	}
	@Override
	public double act(Turtle co) {
		double returnAngle = angleDifference(myAngle, co.getAngle().get());
		co.getAngle().set(myAngle);
		return returnAngle;
	}

}

package backend.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import backend.board.interfacemovement.TurtleNode;
import javafx.scene.Scene;

public class TurtleCollection implements ITurtle {
	private List<Turtle> myTurtles;
	private Scene myScene;
	public TurtleCollection(List<Turtle> turtles, Scene s) {
		myTurtles = turtles;
		myScene = s;
	}

	@Override
	public double act(TurtleNode m) throws IOException {
		double returnValue = 0;
		for(Turtle turtle : getSelectedTurtles()) {
			returnValue = turtle.act(m);			
		}
		return returnValue;
	}
	
	public Scene getScene() {
		return myScene;
	}
	
	private List<Turtle> getSelectedTurtles() {
		List<Turtle> selectedTurtles = new ArrayList<>();
		for(Turtle t : myTurtles) {
			if(t.isSelected()) {
				selectedTurtles.add(t);
			}
		}
		
		return selectedTurtles;
	}
	
	public void addTurtle(Turtle newTurtle) {
		myTurtles.add(newTurtle);
	}
	
	public void removeTurtle(Turtle removeTurtle) {
		myTurtles.remove(removeTurtle);
	}

	@Override
	public void setX(double X) {
		for(Turtle turtle : getSelectedTurtles()) {
			turtle.setX(X);
		}
	}

	@Override
	public void setY(double Y) {
		for(Turtle turtle : getSelectedTurtles()) {
			turtle.setY(Y);
		}
	}

	@Override
	public void setAngle(double angle) {
		for(Turtle turtle : getSelectedTurtles()) {
			turtle.setAngle(angle);
		}
	}

	@Override
	public void setPen(boolean penDown) {
		for(Turtle turtle : getSelectedTurtles()) {
			turtle.setPen(penDown);
		}
	}

	@Override
	public void setOpacity(boolean isVisible) {
		for(Turtle turtle : getSelectedTurtles()) {
			turtle.setOpacity(isVisible);
		}
	}
}

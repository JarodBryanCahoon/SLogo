package backend.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import backend.board.interfacemovement.TurtleNode;
import javafx.scene.Scene;

/**
 * A Class that contains multiple turtles and can call multiple actions on them
 * @author Albert
 * 
 * I chose this as my masterpiece because while it is a simple class that doesn't seem to do a lot, in reality this class is an incredibly useful abstraction of
 * multiple turtles. TurtleCollection uses the proxy pattern by acting as a sort of proxy pattern for multiple turtles. It removes the need for multiple for loops
 * in every single command and logic in every command to find the correctly selected turtles, etc.
 *
 */
public class TurtleCollection extends Observable implements ITurtle {
	private List<Turtle> myTurtles;
	private Scene myScene;
	private int totalTurtlesAdded;
	/**
	 * Creates a new TurtleCollection
	 * @param turtles	List of Turtles to create collection from
	 * @param s			The Scene that the turtlecollection comes from
	 */
	public TurtleCollection(List<Turtle> turtles, Scene s) {
		myTurtles = turtles;
		myScene = s;
		totalTurtlesAdded = turtles.size();
	}

	@Override
	public double act(TurtleNode m) throws IOException {
		double returnValue = 0;
		for(Turtle turtle : getSelectedTurtles()) {
			returnValue = turtle.act(m);			
		}
		return returnValue;
	}
	
	/**
	 * @param id	id of a turtle
	 * @return		whether or not the turtle of id param exists in the turtlecollection
	 */
	public boolean turtleExistsById(int id) {
		for(Turtle t : myTurtles) {
			if(t.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return	the scene of the turtle
	 */
	public Scene getScene() {
		return myScene;
	}
	
	/**
	 * @return	the list of turtles contained in the collection
	 */
	public List<Turtle> getTurtles() {
		return myTurtles;
	}
	
	/**
	 * @return	a list of selected turtles
	 */
	private List<Turtle> getSelectedTurtles() {
		List<Turtle> selectedTurtles = new ArrayList<>();
		for(Turtle t : myTurtles) {
			if(t.isSelected()) {
				selectedTurtles.add(t);
			}
		}
		
		return selectedTurtles;
	}
	
	/**
	 * Adds a turtle to the collection
	 * @param newTurtle	turtle to be added
	 */
	public void addTurtle(Turtle newTurtle) {
		myTurtles.add(newTurtle);
		totalTurtlesAdded++;
	}
	
	/**
	 * Notifies its observing class to create a turtle
	 */
	public void createTurtle() {
		setChanged();
		notifyObservers();
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
	
	/**
	 * @return	the number of turtles added to the collection
	 */
	public int totalTurtlesAdded() {
		return totalTurtlesAdded;
	}
}

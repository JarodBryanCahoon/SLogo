package backend.board.interfacemovement;

import backend.board.ConcreteObject;
import backend.board.Turtle;
import javafx.beans.property.Property;

@FunctionalInterface
public interface MoveInterface{
	public double act(Turtle co); 
}

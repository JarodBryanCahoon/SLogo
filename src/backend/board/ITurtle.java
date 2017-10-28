package backend.board;

import backend.board.interfacemovement.TurtleNode;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

public interface ITurtle {
	double act(TurtleNode m);
}

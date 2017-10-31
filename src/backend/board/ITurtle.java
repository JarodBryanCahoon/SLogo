package backend.board;

import java.io.IOException;

import backend.board.interfacemovement.TurtleNode;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

/**
 * @author Albert
 *
 */
public interface ITurtle {
	double act(TurtleNode m) throws IOException;
	
	void setX(double X);
	
	void setY(double Y);
	
	void setAngle(double angle);
	
	void setPen(boolean penDown);
	
	void setOpacity(boolean isVisible);
}

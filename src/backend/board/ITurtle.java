package backend.board;

import java.io.IOException;

import backend.board.interfacemovement.TurtleNode;

/**
 * @author Albert
 *	An interface that dictates standard methods for a turtle to implement
 */
public interface ITurtle {
	/**
	 * Takes in a TurtleNode strategy and calls its execute method 
	 * @param m	the TurtleNode to be executed			
	 * @return	the double value returned by the execution of the TurtleNode
	 * @throws IOException
	 */
	double act(TurtleNode m) throws IOException;
	
	/**
	 * sets the x value of the turtle
	 * @param X	new x value
	 */
	void setX(double X);
	
	/**
	 * sets the y value of the turtle
	 * @param Y	new y value
	 */
	void setY(double Y);
	
	/**
	 * Sets the angle of the turtle
	 * @param angle	new angle value
	 */
	void setAngle(double angle);
	
	/**
	 * Sets the pen value of the turtle
	 * @param penDown	whether or not the pen is down
	 */
	void setPen(boolean penDown);
	
	/**
	 * sets the opacity value of the turtle
	 * @param isVisible	whether or not the turtle is visible
	 */
	void setOpacity(boolean isVisible);
}

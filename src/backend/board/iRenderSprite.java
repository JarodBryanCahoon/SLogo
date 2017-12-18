package backend.board;

/**
 * @author Albert
 *	An interface that dictates certain standard methods for a rendersprite
 */
public interface iRenderSprite {
	/**
	 * @return the logo x coordinate of the rendersprite & attached turtle
	 */
	double getX();
	
	/**
	 * @return	the logo y coordinate of the rendersprite & attached turtle
	 */
	double getY();
	
	/**
	 * @return	whether or not the pen is down
	 */
	boolean isPenDown();
	
	/**
	 * @return	whether or not the turtle is visible
	 */
	boolean isVisible();
		
	/**
	 * @return	the logo angle of the turtle
	 */
	double getAngle();
	
	/**
	 * @return	the id of the rendersprite/turtle pair
	 */
	int getId();
	
	/**
	 * @return	the math object of the rendersprite
	 */
	RenderMath getMath();
	
	/**
	 * Sets the logo x value of the rendersprite
	 * @param X	new logo x value
	 */
	void setX(double X);
	
	/**
	 * Sets the logo y value of the rendersprite
	 * @param Y	new logo y value
	 */
	void setY(double Y);
	
	/**
	 * Sets the pen value of the rendersprite
	 * @param isPenDown	whether or not the pen is down
	 */
	void setPen(boolean isPenDown);
	
	/**
	 * Sets the visibility of the rendersprite
	 * @param isVisible	whether or not the turtle is visible
	 */
	void setVisibility(boolean isVisible);
	
	/**
	 * Sets the logo angle of the turtle
	 * @param angle	the new logo angle of the turtle
	 */
	void setAngle(double angle);
}

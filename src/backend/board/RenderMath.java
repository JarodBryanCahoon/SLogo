package backend.board;

import javafx.scene.image.ImageView;

/**
 * @author Albert
 *	A class that handles rendering math, especially conversion from the logo 
 *	coordinate system to the javafx coordinate system and back
 */
public class RenderMath {
	private double myWidth;
	private double myHeight;
	private ImageView myImageView;
	/**
	 * Creates a new RenderMath object that is tailored to a specific imageview
	 * @param width		render screen width	 
	 * @param height	render screen height
	 * @param imageView	ImageView to calculate over
	 */
	public RenderMath(double width, double height, ImageView imageView) {
		myWidth = width;
		myHeight = height;
		myImageView = imageView; 
	}
	
	/**
	 * checks if a coordinate is outside the bounds of the render screen
	 * @param coord			coordinate to check
	 * @param bound			bound to check (height or width)
	 * @param widthHeight	either height or width (depending) of the imageview
	 * @return				whether or not the coordinate is outside the bounds of the render (accounting for width/height of image)
	 */
	private boolean outsideBounds(double coord, double bound, double widthHeight) {		
		return coord < 0 || coord > bound - widthHeight; 
	}
	
	/**
	 * Converts the given x logo coordinate to ensure that it does not reach past bound
	 * @param coord	given x logo coordinate
	 * @return		converted x logo coordinate with bound check
	 */
	protected double xTranslate(double coord) {
		double translated = imageX(coord);
		if(!outsideBounds(translated, myWidth, myImageView.getBoundsInLocal().getWidth())) {
			return coord;
		}
		
		double boundaryBroken = (translated < 0) ? 0 : 1;
		return logoX( (myWidth - myImageView.getBoundsInLocal().getWidth()) * boundaryBroken);
	}
	
	/**
	 * Converts the given y logo coordinate to ensure that it does not reach past bound
	 * @param coord	given y logo coordinate
	 * @return		converted y logo coordinate with bound check
	 */
	protected double yTranslate(double coord) {
		double translated = imageY(coord);
		if(!outsideBounds(translated, myHeight, myImageView.getBoundsInLocal().getHeight())) {
			return coord;
		}
		
		translated %= myHeight;
		
		double boundaryBroken = (translated < 0) ? 0 : 1;
		return logoY( (myHeight - myImageView.getBoundsInLocal().getHeight()) * boundaryBroken);
	}
	
	/**
	 * Converts logo x coordinate to javafx x coordinate
	 * @param X	logo x coordinate
	 * @return	mapped javafx x coordinate
	 */
	protected double imageX(double X) {	
		return (X + myWidth / 2 - myImageView.getBoundsInLocal().getWidth() / 2);
	}
	
	/**
	 * Converts javafx x coordinate to logo x coordinate
	 * @param X	javafx x coordinate
	 * @return	mapped logo x coordinate
	 */
	protected double logoX(double X) {
		return (X - myWidth / 2 + myImageView.getBoundsInLocal().getWidth() / 2);
	}
	
	/**
	 * Converts logo y coordinate to javafx y coordinate
	 * @param Y	logo y coordinate
	 * @return	mapped javafx y coordinate
	 */
	protected double imageY(double Y) {
		return (-Y + myHeight / 2 - myImageView.getBoundsInLocal().getHeight() / 2);
	}
	
	/**
	 * Converts javafx y coordinate to logo y coordinate
	 * @param Y	javafx y coordinate
	 * @return	mapped logo x coordinate
	 */
	protected double logoY(double Y) {
		return -Y + myHeight / 2 - myImageView.getBoundsInLocal().getHeight() / 2;
	}
}

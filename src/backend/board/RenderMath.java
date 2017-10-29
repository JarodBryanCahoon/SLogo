package backend.board;

import javafx.scene.image.ImageView;

public class RenderMath {
	private double myWidth;
	private double myHeight;
	private ImageView myImageView;
	public RenderMath(double width, double height, ImageView imageView) {
		myWidth = width;
		myHeight = height;
		myImageView = imageView; 
	}
	
	private boolean outsideBounds(double coord, double bound) {		
		return coord < 0 || coord > bound; 
	}
	
	protected double xTranslate(double coord) {
		double translated = imageX(coord);
		if(!outsideBounds(translated, myWidth)) {
			return logoX(translated);
		}
		
		double boundaryBroken = (translated < 0) ? 1 : 0;
		return logoX(translated + boundaryBroken * myWidth);
	}
	
	protected double yTranslate(double coord) {
		double translated = imageY(coord);
		if(!outsideBounds(translated, myHeight)) {
			return logoY(translated);
		}
		
		double boundaryBroken = (translated < 0) ? 1 : 0;
		return logoY(translated + boundaryBroken * myHeight);
	}
	
	protected double imageX(double X) {	
		return Math.abs( (X + myWidth / 2 - myImageView.getBoundsInLocal().getWidth() / 2) % myWidth );
	}
	
	protected double logoX(double X) {
		return X - myWidth / 2 + myImageView.getBoundsInLocal().getWidth() / 2;
	}
	
	protected double imageY(double Y) {
		return Math.abs( (-Y + myHeight / 2 - myImageView.getBoundsInLocal().getHeight() / 2) % myHeight );
	}
	
	protected double logoY(double Y) {
		return (-Y - myHeight / 2 + myImageView.getBoundsInLocal().getHeight() / 2);
	}
}

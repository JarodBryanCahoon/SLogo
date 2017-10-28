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
	
	public boolean outsideBounds(double coord, double bound) {
		
		return coord < 0 || coord > bound; 
	}
	
	public double xTranslate(double coord) {
		double translated = imageX(coord);
		if(!outsideBounds(translated, myWidth)) {
			return coord;
		}
		
		int boundaryBroken = (translated < 0) ? 1 : 0;
		return logoX(coord + boundaryBroken * myWidth);
	}
	
	public double yTranslate(double coord) {
		double translated = imageY(coord);
		if(!outsideBounds(translated, myHeight)) {
			return coord;
		}
		
		int boundaryBroken = (translated < 0) ? 1 : 0;
		return logoY(coord + boundaryBroken * myHeight);
	}
	
	public double imageX(double X) {
		
		return X + myWidth / 2 - myImageView.getBoundsInLocal().getWidth() / 2;
	}
	
	private double logoX(double X) {
		return X - myWidth / 2 + myImageView.getBoundsInLocal().getWidth() / 2;
	}
	
	public double imageY(double Y) {
		return Y + myHeight / 2 - myImageView.getBoundsInLocal().getHeight() / 2;
	}
	
	private double logoY(double Y) {
		return Y - myHeight / 2 + myImageView.getBoundsInLocal().getHeight() / 2;
	}
}

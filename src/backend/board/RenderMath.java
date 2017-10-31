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
	
	private boolean outsideBounds(double coord, double bound, double widthHeight) {		
		return coord < 0 || coord > bound - widthHeight; 
	}
	
	protected double xTranslate(double coord) {
//		System.out.println("X " + coord);
		double translated = imageX(coord);
		if(!outsideBounds(translated, myWidth, myImageView.getBoundsInLocal().getWidth())) {
			return coord;
		}
		
//		double boundaryBroken = (translated < 0) ? 1 : 0;
//		return logoX(translated + boundaryBroken * myWidth);
		double boundaryBroken = (translated < 0) ? 0 : 1;
		return logoX( (myWidth - myImageView.getBoundsInLocal().getWidth()) * boundaryBroken);
	}
	
	protected double yTranslate(double coord) {
//		System.out.println("Y " + coord);
		double translated = imageY(coord);
		if(!outsideBounds(translated, myHeight, myImageView.getBoundsInLocal().getHeight())) {
			return coord;
		}
		
		translated %= myHeight;
//		double boundaryBroken = (translated < 0) ? 1 : 0;
//		return logoY(translated + boundaryBroken * myHeight);
		
		double boundaryBroken = (translated < 0) ? 0 : 1;
		System.out.println((myHeight - myImageView.getBoundsInLocal().getHeight()) * boundaryBroken);
		return logoY( (myHeight - myImageView.getBoundsInLocal().getHeight()) * boundaryBroken);
	}
	
	protected double imageX(double X) {	
		return (X + myWidth / 2 - myImageView.getBoundsInLocal().getWidth() / 2);
	}
	
	protected double logoX(double X) {
		return (X - myWidth / 2 + myImageView.getBoundsInLocal().getWidth() / 2);
	}
	
	protected double imageY(double Y) {
		return (-Y + myHeight / 2 - myImageView.getBoundsInLocal().getHeight() / 2);
	}
	
	protected double logoY(double Y) {
		return -Y + myHeight / 2 - myImageView.getBoundsInLocal().getHeight() / 2;
	}
}

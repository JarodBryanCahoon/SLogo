package backend.board;

import java.util.LinkedList;
import java.util.Queue;

import frontend.modules.RenderModule;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * @author Albert
 *	Creates and processes the queue of animations for the turtle to run through
 */
public class CustomAnimationQueue {
	private static final int FADE_DURATION = 200;
	private Queue<Animation> myTransitions;
	private Animation currentTransition;
	private boolean animationPlaying = false;
	public static final int DURATION = 1500;
	private RenderSprite myRenderSprite;
	private RenderModule myRenderModule;
	private boolean initTranslation = false;
	private double xTranslate = 0;
	private double yTranslate = 0;
	
	/**
	 * Creates a new Queue of javafx animations
	 * @param rs		RenderSprite to animate
	 * @param render	RenderModule to animate on
	 */
	public CustomAnimationQueue(RenderSprite rs, RenderModule render) {
		myRenderModule = render;
		myTransitions = new LinkedList<>();	
		myRenderSprite = rs;
	}
	
	/**
	 * Adds animation to queue and runs the next animation in the queue if no animation is playing
	 * @param newTransition
	 */
	private void runQueue(Transition newTransition) {
		myTransitions.add(newTransition);
		if(!animationPlaying) {
			animationPlaying = true;
			currentTransition = myTransitions.poll();
			currentTransition.play();
		}
	}
	
	/**
	 * Creates a fade transition from opacity oldOp to opacity newOp
	 * @param oldOp	old opacity value
	 * @param newOp	new opacity value
	 */
	protected void appendFadeTransition(double oldOp, double newOp) {
        FadeTransition fadeTransition = 
                new FadeTransition(Duration.millis(FADE_DURATION), myRenderSprite.getImage());
        fadeTransition.setFromValue(oldOp);
        fadeTransition.setToValue(newOp);
        fadeTransition.setOnFinished(e -> checkQueue());
        runQueue(fadeTransition);
	}	

	/**
	 * Create a fade transition from boolean oldOp to boolean newOp
	 * @param oldOp	old visibility value
	 * @param newOp new visibility value
	 */
	protected void appendFadeTransition(boolean oldOp, boolean newOp) {
		double oldDoubleVisibility = oldOp ? 1 : 0;
		double newDoubleVisibility = newOp ? 1 : 0;
		appendFadeTransition(oldDoubleVisibility, newDoubleVisibility);
	}
	
	/**
	 * Add a new translation transition that moves the turtle in a line
	 * @param clrScrn	whether or not the turtle has called clearscreen
	 */
	protected void appendTranslationTransition(boolean clrScrn, double oldX, double oldY) {
		RenderMath rMath = myRenderSprite.getMath();
		ImageView image = myRenderSprite.getImage();
		oldX = rMath.imageX(oldX);
		oldY = rMath.imageY(oldY);
		
		double newX = rMath.imageX(myRenderSprite.getX());
		double newY = rMath.imageY(myRenderSprite.getY());
				
		TranslateTransition xTranslateTransition =
		        new TranslateTransition(Duration.millis(DURATION), image);
		xTranslateTransition.setToX(newX - oldX);
		TranslateTransition yTranslateTransition =
		        new TranslateTransition(Duration.millis(DURATION), myRenderSprite.getImage());
		yTranslateTransition.setToY(newY - oldY);
		
		ParallelTransition pTransition = createParallelTranslationTransition(
				newX + image.getBoundsInLocal().getWidth() / 2, newY + image.getBoundsInLocal().getHeight() / 2, xTranslateTransition,
				yTranslateTransition, clrScrn);
		runQueue(pTransition);
	}

	private ParallelTransition createParallelTranslationTransition(double newX, double newY,
			TranslateTransition xTranslateTransition, TranslateTransition yTranslateTransition, boolean clrScrn) {
		ParallelTransition pTransition = new ParallelTransition();
		pTransition.getChildren().addAll(xTranslateTransition, yTranslateTransition);
		pTransition.setOnFinished(e -> onFinish(myRenderSprite.isPenDown(), newX, newY, clrScrn));
		return pTransition;
	}
	
	/**
	 * Creates a new rotation animation for the imageview
	 * @param oldAngle	angle to rotate from
	 * @param newAngle	angle to rotate to
	 */
	protected void appendRotationAnimation(double oldAngle, double newAngle) {
		double oldImageAngle = 360 - oldAngle;
		RotateTransition rTransition = new RotateTransition(Duration.millis(FADE_DURATION), myRenderSprite.getImage());
		rTransition.setFromAngle(oldImageAngle);
		rTransition.setToAngle(newAngle);
		rTransition.setOnFinished(e -> checkQueue());
		runQueue(rTransition);
	}
	
	/**
	 * handle logic for drawing of line and image updating
	 * @param penDown	whether or not the pen is down
	 * @param newX		x coordinate to draw line to
	 * @param newY		y coordinate to draw line to
	 * @param clrScrn	whether or not the turtle has cleared screen
	 */
	private void onFinish(boolean penDown, double newX, double newY, boolean clrScrn) {
		ImageView image = myRenderSprite.getImage();
		if(penDown && !clrScrn) {
			myRenderModule.drawLine(myRenderSprite.getId(), newX, newY);
		}
		xTranslate = image.getTranslateX();
		yTranslate = image.getTranslateY();
		image.setX(image.getX() + image.getTranslateX());
		image.setY(image.getY() + image.getTranslateY());
		image.setTranslateX(0);
		image.setTranslateY(0);

		checkQueue();
	}

	/**
	 * run next animation if queue is not empty; otherwise reset animation playing
	 */
	private void checkQueue() {
		if(!myTransitions.isEmpty()) {
			currentTransition = myTransitions.poll();
			currentTransition.play();
		} else {
			animationPlaying = false;
		}
	}
}

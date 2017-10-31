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

public class CustomAnimationQueue {
	private static final int FADE_DURATION = 200;
	private Queue<Animation> myTransitions;
	private Animation currentTransition;
	private boolean animationPlaying = false;
	public static final int DURATION = 1500;
	private RenderSprite myRenderSprite;
	private RenderModule myRenderModule;
	private double xDraw;
	private double yDraw;
	private boolean initTranslation = false;
	
	public CustomAnimationQueue(RenderSprite rs, RenderModule render) {
		myRenderModule = render;
		myTransitions = new LinkedList<>();	
		myRenderSprite = rs;
	}
	
	private void runQueue(Transition newTransition) {
		myTransitions.add(newTransition);
		if(!animationPlaying) {
			animationPlaying = true;
			currentTransition = myTransitions.poll();
			currentTransition.play();
		}
	}
	
	protected void appendFadeTransition(double oldOp, double newOp) {
        FadeTransition fadeTransition = 
                new FadeTransition(Duration.millis(FADE_DURATION), myRenderSprite.getImage());
        fadeTransition.setFromValue(oldOp);
        fadeTransition.setToValue(newOp);
        fadeTransition.setOnFinished(e -> checkQueue());
        runQueue(fadeTransition);
	}
	

	protected void appendFadeTransition(boolean oldOp, boolean newOp) {
		double oldDoubleVisibility = oldOp ? 1 : 0;
		double newDoubleVisibility = newOp ? 1 : 0;
		appendFadeTransition(oldDoubleVisibility, newDoubleVisibility);
	}
	
	protected void appendTranslationTransition() {
		RenderMath rMath = myRenderSprite.getMath();
		ImageView image = myRenderSprite.getImage();
		double oldX = image.getX();
		double oldY = image.getY();
		checkInit(image, oldX, oldY);
		
		double newX = rMath.imageX(myRenderSprite.getX());
		double newY = rMath.imageY(myRenderSprite.getY());
		
		double avg = Math.abs((newX + newY - oldX - oldY)) / 2;
		
		TranslateTransition xTranslateTransition =
		        new TranslateTransition(Duration.millis(DURATION), image);
		xTranslateTransition.setToX(newX - oldX);
		TranslateTransition yTranslateTransition =
		        new TranslateTransition(Duration.millis(DURATION), myRenderSprite.getImage());
		yTranslateTransition.setToY(newY - oldY);
		
		ParallelTransition pTransition = createParallelTranslationTransition(
				newX + image.getBoundsInLocal().getWidth() / 2, newY + image.getBoundsInLocal().getHeight() / 2, xTranslateTransition,
				yTranslateTransition);
		runQueue(pTransition);
	}

	private void checkInit(ImageView image, double oldX, double oldY) {
		if(!initTranslation) {
			xDraw = oldX + image.getBoundsInLocal().getWidth() / 2;
			yDraw = oldY + image.getBoundsInLocal().getHeight() / 2;
			initTranslation = true;
		}
	}

	private ParallelTransition createParallelTranslationTransition(double newX, double newY,
			TranslateTransition xTranslateTransition, TranslateTransition yTranslateTransition) {
		ParallelTransition pTransition = new ParallelTransition();
		pTransition.getChildren().addAll(xTranslateTransition, yTranslateTransition);
		System.out.println("should also be home " + newY);
		pTransition.setOnFinished(e -> onFinish(myRenderSprite.isPenDown(), newX, newY));
		return pTransition;
	}
	
	protected void appendRotationAnimation(double oldAngle, double newAngle) {
		System.out.println("entered rotation");
		double oldImageAngle = 360 - oldAngle;
		System.out.println(oldImageAngle);
		System.out.println(newAngle);
		RotateTransition rTransition = new RotateTransition(Duration.millis(FADE_DURATION), myRenderSprite.getImage());
		rTransition.setFromAngle(oldImageAngle);
		rTransition.setToAngle(newAngle);
		rTransition.setOnFinished(e -> checkQueue());
		runQueue(rTransition);
	}
	
	private void onFinish(boolean penDown, double newX, double newY) {
		if(penDown) {
			myRenderModule.drawLine(myRenderSprite.getId(), xDraw, yDraw, newX, newY);
		}
		xDraw = newX;
		yDraw = newY;
		checkQueue();
	}

	private void checkQueue() {
		if(!myTransitions.isEmpty()) {
			currentTransition = myTransitions.poll();
			currentTransition.play();
		} else {
			animationPlaying = false;
		}
	}
}

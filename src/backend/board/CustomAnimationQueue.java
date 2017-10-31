package backend.board;

import java.util.LinkedList;
import java.util.Queue;

import frontend.modules.RenderModule;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CustomAnimationQueue {
	private Queue<Animation> myTransitions;
	private Animation currentTransition;
	private boolean animationPlaying = false;
	public static final int DURATION = 2000;
	private RenderSprite myRenderSprite;
	private RenderModule myRenderModule;
	
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
	
	protected void appendTranslationTransition() {
		RenderMath rMath = myRenderSprite.getMath();
		ImageView image = myRenderSprite.getImage();
		double oldX = image.getX();
		double oldY = image.getY();
		double newX = rMath.imageX(myRenderSprite.getX());
		double newY = rMath.imageY(myRenderSprite.getY());
		
		TranslateTransition xTranslateTransition =
		        new TranslateTransition(Duration.millis(DURATION), image);
		xTranslateTransition.setToX(newX - oldX);
		TranslateTransition yTranslateTransition =
		        new TranslateTransition(Duration.millis(DURATION), myRenderSprite.getImage());
		yTranslateTransition.setToY(newY - oldY);
		
		ParallelTransition pTransition = new ParallelTransition();
		pTransition.getChildren().addAll(xTranslateTransition, yTranslateTransition);
		pTransition.setOnFinished(e -> onFinish(myRenderSprite.isPenDown(), oldX + image.getLayoutX(), oldY + image.getLayoutY(), newX, newY));
		runQueue(pTransition);
	}
	
	protected void appendRotationAnimation(double oldAngle, double newAngle) {
		RotateTransition rTransition = new RotateTransition(Duration.millis(DURATION), myRenderSprite.getImage());
		double oldImageAngle = 360 - oldAngle;
		rTransition.setFromAngle(oldImageAngle);
		rTransition.setToAngle(newAngle);
		rTransition.setOnFinished(e -> onFinish());
		runQueue(rTransition);
	}
	
	private void onFinish(boolean penDown, double oldX, double oldY, double newX, double newY) {
		System.out.println("finished");
		System.out.println(newY);
		
//		double oldX = myRenderSprite.getMath().imageX(myRenderSprite.getX());
//		double oldY = myRenderSprite.getMath().imageY(myRenderSprite.getY());
		if(penDown) {
			myRenderModule.drawLine(myRenderSprite.getId(), oldX, oldY, newX, newY);
		}
		checkQueue();

	}
	
	private void onFinish() {
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

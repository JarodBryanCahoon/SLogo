package backend.interpreter;

import java.util.ArrayList;
import java.util.List;

import backend.board.RenderSprite;
import backend.board.TurtleCollection;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class StepThrough {
	private List<TurtleCollection> previousTurtleStates;
	private List<List<RenderSprite>> previousSpriteStates;
	private List<Pane> previousRenderStates;
	private int totalSteps = 0;
	private int currentStep = 0;
	public StepThrough() {
		previousTurtleStates = new ArrayList<>();
		previousSpriteStates = new ArrayList<>();
		previousRenderStates = new ArrayList<>();
	}
	
	protected void add(TurtleCollection turtleState) {
		try {
			previousTurtleStates.add(currentStep + 1, turtleState);
		} catch (IndexOutOfBoundsException e) {
			previousTurtleStates.add(turtleState);
		}
	}
	
	protected void add(List<RenderSprite> spriteState) {
//		List<ImageView> myList = new ArrayList<>();
//		for(RenderSprite rs : spriteState) {
//			ImageView myImage = new ImageView(rs.getImage());
//		}
		
		try {
			previousSpriteStates.add(currentStep + 1, spriteState);
		} catch (IndexOutOfBoundsException e) {
			previousSpriteStates.add(spriteState);
		}
	}
	
	protected void add(Pane renderState) {
		try {
			previousRenderStates.add(currentStep + 1, renderState);
		} catch (IndexOutOfBoundsException e) {
			previousRenderStates.add(renderState);

		}
	}
	
	protected void increment() {
		totalSteps++;
		currentStep++;
	}
	
	protected void undo(Manager myManager) {
		System.out.println(currentStep);
		currentStep--;
		if(currentStep < 0) {
			return;
		}
		System.out.println(currentStep);

		System.out.println("undo");

		resetState(myManager);
	}
	
	protected void redo(Manager myManager) {
		currentStep++;
		if(currentStep > totalSteps) {
			return;
		}
		System.out.println("redo");
		resetState(myManager);
	}

	private void resetState(Manager myManager) {
		myManager.setTurtleCollection(previousTurtleStates.get(currentStep));
		myManager.setSpriteState(previousSpriteStates.get(currentStep));
//		myManager.setRenderState(previousRenderStates.get(currentStep));
	}
}

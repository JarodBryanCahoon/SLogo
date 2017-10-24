package frontend.modules;

import java.util.List;
import java.util.Observer;

import backend.board.RenderSprite;
import frontend.observation.SpriteObserver;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RenderModule extends Module{
	private List<RenderSprite> mySprites;

	public RenderModule(double width, double height) throws Exception {
		super(width, height);
	}
	
	@Override
	protected Parent createParent() throws Exception {
		Pane myGroup = new Pane();
		myGroup.setLayoutX(getWidth());
		myGroup.setLayoutY(getHeight());
//		myGroup.setPrefSize(getWidth(), getHeight());
		myGroup.setStyle("-fx-background-color : black");
		Button b = new Button("help");
		myGroup.getChildren().add(b);
		// add turtle
		return myGroup;
	}
	
	public void clearScreen() {
		((Group) getParent()).getChildren().removeAll(mySprites);
		mySprites.removeAll(mySprites);
	}
	
	public void addRenderSprite(RenderSprite sprite) {
		mySprites.add(sprite);
	}

	public void updateRenderSprite(RenderSprite newSprite) {
		RenderSprite oldSprite = findSpriteById(newSprite);
		renderTransition(oldSprite, newSprite);
	}
	
	private RenderSprite findSpriteById(RenderSprite newSprite) {
		for(RenderSprite rSprite : mySprites) {
			if(rSprite.getId() == newSprite.getId()) {
				return rSprite;
			}
		}
		return null;
	}
	
	private void renderTransition(RenderSprite oldSprite, RenderSprite newSprite) {
		mySprites.add(mySprites.indexOf(oldSprite), newSprite);
		// add old sprite to history		
	}
	
	private double translateX(double X) {
		return X + getWidth() / 2;
	}
	
	private double translateY(double Y) {
		return Y + getHeight() / 2;
	}
}

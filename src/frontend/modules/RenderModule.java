package frontend.modules;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * @author Albert
 *
 */
public class RenderModule extends Module{
	private List<RenderSprite> mySprites;
	private int turtleId = 1;
	private Group myGroup;
	private static final String turtlePath = "/resources/turtle.png";
	private Queue<Animation> myTransitions;
	private Animation currentTransition;
	private boolean animationPlaying = false;;
			
	public RenderModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
		addTurtle();
		myTransitions = new LinkedList<>();
	}
	
	@Override
	protected Parent createParent() throws Exception {
		mySprites = new ArrayList<>();
		Pane myPane = new Pane();
		myPane.setMinSize(getWidth(), getHeight());
		
		myGroup = new Group();
		myPane.getChildren().add(myGroup);

		myPane.getStyleClass().add("Render");
		stylize();
		return myPane;
	}
	
	public RenderSprite addTurtle() {
		Pane myPane = (Pane) getParent();
		RenderSprite sprite = new RenderSprite(turtleId, turtlePath, getWidth(), getHeight(), this);
		myPane.getChildren().add(sprite.getImage());
		mySprites.add(sprite);
		turtleId++;
		return sprite;
	}
	
	//https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm
	public void drawLine(int turtleId, double oldX, double oldY) {
		RenderSprite sprite = findSpriteById(turtleId);
		if(sprite == null) {
			return;
		}
		double newX = sprite.getImage().getX();
		double newY = sprite.getImage().getY();
		System.out.println(newX);
		Line line = new Line(oldX,oldY,newX,newY);
		System.out.println(line.getEndX());
		System.out.println(line.getStartX());
		myGroup.getChildren().add(line);
		
	}
	
	private RenderSprite findSpriteById(int turtleId) {
		for(RenderSprite sprite : mySprites) {
			if(sprite.getId() == turtleId) {
				return sprite;
			}
		}
		return null;
	}
	
	public void clearScreen() {
		Pane myPane = (Pane) getParent();
		for(RenderSprite s : mySprites) {
			myPane.getChildren().remove(s.getImage());
		}
		mySprites.clear();
		myPane.getChildren().remove(myGroup);
		myGroup = new Group();
		addTurtle();
		myPane.getChildren().add(myGroup);
	}
	
	public Element getXMLPreferences(Document doc) {
		Element cls = doc.createElement(PreferenceXMLReader.RenderTags.MODULE.getTag());
		
		cls.appendChild(XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.NAME.getTag(), this.getClass().getName().toString()));
		cls.appendChild(XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.STAGE_HEIGHT.getTag(), Double.toString(getHeight())));
		cls.appendChild(XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.STAGE_WIDTH.getTag(), Double.toString(getWidth())));
		
		try {
			for(RenderSprite rSprite : mySprites) {
				Element xmlSprite = rSprite.getTurtleXML(doc);
				cls.appendChild(xmlSprite);			
			}
		} catch(NullPointerException e) {
			ErrorMessage message = new ErrorMessage("Could not write to File");
			message.show();
		}		
		return cls;
	}
	
	private void stylize() {
			myGroup.getStyleClass().add("Render");
	}
	
	public List<RenderSprite> getSprites() {
		return mySprites;
	}
	
	public void appendTransition(Animation newTransition) {
		myTransitions.add(newTransition);
		while(!myTransitions.isEmpty()) {
			while(animationPlaying) {
				
			}
			animationPlaying = true;
			System.out.println("past wait conidtion");
			currentTransition = myTransitions.poll();
			currentTransition.setOnFinished(e -> notPlaying());
			currentTransition.play();
		}
	}
	
	private void notPlaying() {
		animationPlaying = false;
	}
}

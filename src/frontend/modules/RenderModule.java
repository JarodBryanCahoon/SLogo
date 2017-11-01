package frontend.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * A class that handles the rendering of the turles
 * @author Albert
 *
 */
public class RenderModule extends Module {
	private List<RenderSprite> mySprites;
	private Map<RenderSprite, List<Line>> mySpriteLines;
	private int turtleId = 1;
	private Group myGroup;
	private static final String turtlePath = "/resources/turtle.png";

	/**
	 * Creates a new RenderModule
	 * @param width		width of module
	 * @param height	height of module
	 * @param view		associated ViewModule
	 * @throws Exception
	 */
	public RenderModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
		mySpriteLines = new HashMap<>();
		addTurtle();
	}

	@Override
	protected Parent createParent() throws Exception {
		mySprites = new ArrayList<>();
		Pane myPane = new Pane();
		myPane.setMinSize(getWidth(), getHeight());

		myGroup = new Group();
		myPane.getChildren().add(myGroup);

		myPane.getStyleClass().add("Render");
		return myPane;
	}

	/**
	 * add a new RenderSprite to the RenderModule's list
	 * @return	created RenderSprite
	 */
	public RenderSprite addTurtle() {
		Pane myPane = (Pane) getParent();
		RenderSprite sprite = new RenderSprite(turtleId, turtlePath, getWidth(), getHeight(), this);
		myPane.getChildren().add(sprite.getImage());
		mySprites.add(sprite);
		mySpriteLines.put(sprite, new ArrayList<>());
		turtleId++;
		return sprite;
	}

	// https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm
	/**
	 * Draws a line from the turtleId's "current" position (as defined by javafx animations) and its new position
	 * Adds line to mapping from turtle to list of lines
	 * @param turtleId	id of turtle drawing line
	 * @param newX		new x position of turtle
	 * @param newY		new y position of turtle
	 */
	public void drawLine(int turtleId, double newX, double newY) {
		RenderSprite sprite = findSpriteById(turtleId);
		ImageView image = sprite.getImage();
		double oldX = image.getX() + image.getBoundsInLocal().getWidth() / 2;
		double oldY = image.getY() + image.getBoundsInLocal().getHeight() / 2;
		
		Line line = new Line(oldX, oldY, newX, newY);
		line.getStyleClass().add("Render");
		myGroup.getChildren().add(line);
		mySpriteLines.get(sprite).add(line);
	}

	private RenderSprite findSpriteById(int turtleId) {
		for (RenderSprite sprite : mySprites) {
			if (sprite.getId() == turtleId) {
				return sprite;
			}
		}
		return null;
	}

	/**
	 * clears the screen for selected turtles
	 */
	public void clearScreen() {
		Iterator<RenderSprite> renderIter = mySprites.iterator();
		while(renderIter.hasNext()) {
			RenderSprite s = renderIter.next();
			if(s.isSelected()) {
				List<Line> lineList = mySpriteLines.get(s);
				myGroup.getChildren().removeAll(lineList);			
			}
		}
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		Element cls = doc.createElement(PreferenceXMLReader.RenderTags.MODULE.getTag());

		cls.appendChild(XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.NAME.getTag(),
				this.getClass().getName().toString()));
		cls.appendChild(XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.STAGE_HEIGHT.getTag(),
				Double.toString(getHeight())));
		cls.appendChild(XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.STAGE_WIDTH.getTag(),
				Double.toString(getWidth())));

		try {
			for (RenderSprite rSprite : mySprites) {
				Element xmlSprite = rSprite.getTurtleXML(doc);
				cls.appendChild(xmlSprite);
			}
		} catch (NullPointerException e) {
			ErrorMessage message = new ErrorMessage("Could not write to File");
			message.show();
		}
		return cls;
	}

	/**
	 * @return	a list of contained rendersprites
	 */
	public List<RenderSprite> getSprites() {
		return mySprites;
	}
	
	/**
	 * theoretically will set the state of the sprite list to a previous state
	 * @param spriteState	previous list of rendersprites
	 */
	public void setSpriteState(List<RenderSprite> spriteState) {
		Pane myPane = (Pane) getParent();
		myPane.getChildren().clear();
		for(RenderSprite rs : spriteState) {
			myPane.getChildren().add(rs.getImage());
		}
		mySprites = spriteState;
	}
	
	/**
	 * theoretically will set the state of the render to a previous state
	 * @param renderState	previous render state
	 */
	public void setRenderState(Parent renderState) {
		setParent(renderState);
	}

	/**
	 * Replace a turtle's image
	 * @param oldImage	image to be removd
	 * @param newImage	image to be added
	 */
	public void replaceImage(ImageView oldImage, ImageView newImage) {
		Pane parent = (Pane) getParent();
		parent.getChildren().remove(oldImage);
		parent.getChildren().add(newImage);
	}
}

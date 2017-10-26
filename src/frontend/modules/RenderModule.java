package frontend.modules;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class RenderModule extends Module{
	private static final double SELECTED = 1.0;
	private static final double NONSELECTED = 0.5;
	private List<RenderSprite> mySprites;
	private int turtleId = 0;
	private Canvas myCanvas;
	private static final String turtlePath = "/resources/turtle.png";
	private RenderSprite selectedSprite;	
			
	public RenderModule(double width, double height) throws Exception {
		super(width, height);
	}
	
	@Override
	protected Parent createParent() throws Exception {
		stylize();
		Group myGroup = new Group();
		myCanvas = new Canvas();
		myGroup.getChildren().add(myCanvas);
		mySprites = new ArrayList<>();
		addTurtle(myGroup);		
		return myGroup;
	}
	
	public void addTurtle(Group group) {
		RenderSprite sprite = new RenderSprite(turtleId, turtlePath, getWidth(), getHeight(), this);
		group.getChildren().add(sprite.getImage());
		mySprites.add(sprite);
		selectTurtle(sprite.getId());
		turtleId++;
	}
	
	//https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm
	public void drawLine(int turtleId, double oldX, double oldY) {
		RenderSprite sprite = findSpriteById(turtleId);
		if(sprite == null) {
			return;
		}
		
		GraphicsContext gc = myCanvas.getGraphicsContext2D();
		gc.strokeLine(oldX, oldY, sprite.getX(), sprite.getY());
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
		Group myGroup = (Group) getParent();
		for(RenderSprite sprite : mySprites) {
			myGroup.getChildren().remove(sprite.getImage());
		}
		mySprites.removeAll(mySprites);
		turtleId = 0;
	}
	
	public void addRenderSprite(RenderSprite sprite) {
		mySprites.add(sprite);
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
		myCanvas.getStyleClass().add("Render");
	}

	public void selectTurtle(int id) {
		selectedSprite.getImage().setOpacity(NONSELECTED);
		selectedSprite = findSpriteById(id);
		selectedSprite.getImage().setOpacity(SELECTED);
	}
}

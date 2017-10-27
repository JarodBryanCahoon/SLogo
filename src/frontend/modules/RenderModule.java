package frontend.modules;

import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

public class RenderModule extends Module{
	private List<RenderSprite> mySprites;
	private Map<RenderSprite, List<Line>> spriteLines;
	private int turtleId = 0;
	private Canvas myCanvas;
	private static final String turtlePath = "/resources/turtle.png";
			
	public RenderModule(double width, double height, ViewModule view) throws Exception {
		super(width, height, view);
	}
	
	@Override
	protected Parent createParent() throws Exception {
		spriteLines = new HashMap<>();
		mySprites = new ArrayList<>();

		Group myGroup = new Group();
		myCanvas = new Canvas();
		myGroup.getChildren().add(myCanvas);
		addTurtle(myGroup);		
		stylize();
		return myGroup;
	}
	
	private void addTurtle(Group group) {
		RenderSprite sprite = new RenderSprite(turtleId, turtlePath, getWidth(), getHeight(), this);
		group.getChildren().add(sprite.getImage());
		mySprites.add(sprite);
		spriteLines.put(sprite, new ArrayList<>());
		turtleId++;
	}
	
	//https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm
	public void drawLine(int turtleId, double oldX, double oldY) {
		RenderSprite sprite = findSpriteById(turtleId);
		if(sprite == null) {
			return;
		}
		
		GraphicsContext gc = myCanvas.getGraphicsContext2D();
		Line newLine = new Line(oldX, oldY, sprite.getX(), sprite.getY());
		// ask lasia about css
		( (Group) getParent() ).getChildren().add(newLine);
		spriteLines.get(sprite).add(newLine);
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
		myGroup.getChildren().removeAll(myGroup.getChildren());
		mySprites.clear();
		spriteLines.clear();
		turtleId = 0;
		addTurtle(myGroup);
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
	
	public List<RenderSprite> getSelectedSprites() {
		List<RenderSprite> selectedSprites = new ArrayList<>();
		for(RenderSprite s : mySprites) {
			if(s.isSelected()) {
				selectedSprites.add(s);
			}
		}
		return selectedSprites;
	}
}

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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * @author Albert
 *
 */
public class RenderModule extends Module {
	private List<RenderSprite> mySprites;
	private Map<RenderSprite, List<Line>> mySpriteLines;
	private int turtleId = 1;
	private Group myGroup;
	private static final String turtlePath = "/resources/turtle.png";

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
		stylize();
		return myPane;
	}

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
	public void drawLine(int turtleId, double oldX, double oldY, double newX, double newY) {
		RenderSprite sprite = findSpriteById(turtleId);
		if (sprite == null) {
			return;
		}
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

	public void clearScreen() {
		Pane myPane = (Pane) getParent();
		Iterator<RenderSprite> renderIter = mySprites.iterator();
		while(renderIter.hasNext()) {
			RenderSprite s = renderIter.next();
			List<Line> lineList = mySpriteLines.get(s);
			myGroup.getChildren().removeAll(lineList);
		}
	}

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

	private void stylize() {
		// myGroup.getStyleClass().add("Render");
	}

	public List<RenderSprite> getSprites() {
		return mySprites;
	}
}

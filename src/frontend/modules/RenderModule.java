package frontend.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class RenderModule extends Module{
	private List<RenderSprite> mySprites;
	private int turtleId = 0;
	private static final String turtlePath = "/resources/turtle.png";
			
	public RenderModule(double width, double height) throws Exception {
		super(width, height);
	}
	
	@Override
	protected Parent createParent() throws Exception {
		Group myGroup = new Group();
		mySprites = new ArrayList<>();
		addTurtle(myGroup);
		return myGroup;
	}
	
	public void addTurtle(Group group) {
		RenderSprite sprite = new RenderSprite(turtleId, turtlePath, getWidth(), getHeight());
		group.getChildren().add(sprite.getImage());
		mySprites.add(sprite);
		turtleId++;
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
}

package frontend.modules;

import java.util.List;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.board.RenderSprite;
import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class RenderModule extends Module{
	private List<RenderSprite> mySprites;

	public RenderModule(double width, double height) throws Exception {
		super(width, height);
	}
	
	@Override
	protected Parent createParent() throws Exception {
		Group myGroup = new Group();
//		myGroup.setPrefSize(getWidth(), getHeight());
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
	
	public Element getXMLPreferences(Document doc, Element root) {
		Element cls = doc.createElement(this.getClass().toString());
		root.appendChild(cls);
		
		XMLReader.createTextElement(doc, cls, PreferenceXMLReader.RenderTags.STAGE_HEIGHT.getTag(), Double.toString(getHeight()));
		XMLReader.createTextElement(doc, cls, PreferenceXMLReader.RenderTags.STAGE_WIDTH.getTag(), Double.toString(getWidth()));
		
		for(RenderSprite rSprite : mySprites) {
			Element xmlSprite = rSprite.getTurtleXML(doc, cls);
		}
		
		return cls;
	}
}

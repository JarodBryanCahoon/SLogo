package backend.board;

import java.util.Observable;
import java.util.Observer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import frontend.modules.RenderModule;
import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;
import javafx.scene.image.ImageView;

public class RenderSprite extends Observable implements iRenderSprite, Observer {
	private static final String TURTLE = "turtle";
	private static final String XML_SPRITE = "sprite";
	private double myX = Turtle.STARTING_POSITION[0];
	private double myY = Turtle.STARTING_POSITION[1];
	private ImageView myImageView;
	private boolean penDown = true;
	private double myPenWidth;
	private boolean isVisible = true;	
	private double myAngle = Turtle.STARTING_ANGLE;
	private double myImageAngle;
	private int myTurtleId;
	private String myImagePath;
	private RenderMath myRenderMath;
	private RenderModule myRender;
	
	public RenderSprite(int id, String imagePath, double width, double height, RenderModule render) {
		myRender = render;
		myImageAngle = -myAngle;
		myTurtleId = id;
		myImagePath = imagePath;
		myImageView = new ImageView(imagePath);		
		myRenderMath = new RenderMath(width, height, myImageView);		
		myImageView.setX(myRenderMath.xTranslate(myX));
		myImageView.setY(myRenderMath.yTranslate(myY));
		myImageView.setRotate(myImageAngle);
		myImageView.setOnMouseClicked(e -> myRender.selectTurtle(myTurtleId));
	}
	
	public boolean isPenDown() {
		return penDown;
	}
	
	public double getPenWidth() {
		return myPenWidth;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public double getX() {
		return myX;
	}
	
	public double getY() {
		return myY;
	}

	public int getId() {
		return myTurtleId;
	}
	
	public ImageView getImage() {
		return myImageView;
	}
	
	public void stylize() {
		myImageView.getStyleClass().add(TURTLE);
	}

	@Override
	public double getAngle() {
		return myAngle;
	}
	
	/**
	 * @param turtle
	 * @return	the old x pos value of the turtle
	 */
	private double changeX(Turtle turtle) {
		double myOldX = myX;
		myX = myRenderMath.xTranslate(turtle.getMyX().get());		
		myImageView.setX(myRenderMath.imageX(myX));
		return myOldX;
	}
	
	/**
	 * @param turtle
	 * @return	the old value y pos of the turtle
	 */
	private double changeY(Turtle turtle) {
		double myOldY = myY;
		myY = myRenderMath.yTranslate(turtle.getMyY().get());		
		myImageView.setY(myRenderMath.imageY(myY));
		return myOldY;
	}

	private void changeAngle(Turtle turtle) {
		myAngle = turtle.getAngle().get();
		myImageAngle = -myAngle;
		myImageView.setRotate(myImageAngle);
	}

	private void changePen(Turtle turtle) {
		penDown = turtle.getPen().get();
	}

	private void changeOpacity(Turtle turtle) {
		isVisible = turtle.getOpacity().get();
		myImageView.setVisible(isVisible);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Turtle turtle = (Turtle) arg0;
		double oldX = changeX(turtle);
		double oldY = changeY(turtle);
		changePen(turtle);

		if(penDown) {
			myRender.drawLine(myTurtleId, oldX, oldY);
		}
		changeAngle(turtle);
		changeOpacity(turtle);	
	}	

	public Element getTurtleXML(Document doc) {
		Element xmlElement = doc.createElement(XML_SPRITE);
		xmlElement.appendChild(XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.MYX.getTag(), Double.toString(myX)));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.MYY.getTag(), Double.toString(myY));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.PEN.getTag(), Boolean.toString(penDown));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.PEN_WIDTH.getTag(), Double.toString(myPenWidth));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.VISIBILITY.getTag(), Boolean.toString(isVisible));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.ANGLE.getTag(), Double.toString(myAngle));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.ID.getTag(), Integer.toString(myTurtleId));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.PATH.getTag(), myImagePath);
		return xmlElement;
	}
}

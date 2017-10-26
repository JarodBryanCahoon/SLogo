package backend.board;

import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;

import java.util.Observable;

import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
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
	
	public RenderSprite(int id, String imagePath, double width, double height) {
		myImageAngle = -myAngle;
		myTurtleId = id;
		myImagePath = imagePath;
		myImageView = new ImageView(imagePath);		
		myRenderMath = new RenderMath(width, height, myImageView);		
		myImageView.setX(myRenderMath.xTranslate(myX));
		myImageView.setY(myRenderMath.yTranslate(myY));
		myImageView.setRotate(myImageAngle);
	}
	
	public double isPenDown() {
		return penDown? 1:0;
	}
	
	public double getPenWidth() {
		return myPenWidth;
	}
	
	public double isVisible() {
		return isVisible? 1:0;
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
	
	protected void changeX(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myX = myRenderMath.xTranslate(newVal.doubleValue());		
		myImageView.setX(myRenderMath.imageX(myX));
	}
	
	protected void changeY(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myY = myRenderMath.yTranslate(newVal.doubleValue());		
		myImageView.setY(myRenderMath.imageY(myY));
	}

	protected void changeAngle(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myAngle = newVal.doubleValue();
		myImageAngle = -myAngle;
		myImageView.setRotate(myImageAngle);
	}

	protected void changePen(ObservableValue<? extends Boolean> obs, Boolean oldVal, Boolean newVal) {
		penDown = newVal.booleanValue();
	}

	protected void changeOpacity(ObservableValue<? extends Boolean> obs, Boolean oldVal, Boolean newVal) {
		isVisible = newVal.booleanValue();
		myImageView.setVisible(isVisible);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
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

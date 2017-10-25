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
	private double myX;
	private double myY;
	private ImageView myImageView;
	private boolean penDown;
	private double myPenWidth;
	private boolean isVisible;	
	private double myAngle;
	private int myTurtleId;
	private double stageWidth;
	private double stageHeight;
	private String myImagePath;
	
	public RenderSprite(int id, String imagePath, double width, double height) {
		myX = Turtle.STARTING_POSITION[0];
		myY = Turtle.STARTING_POSITION[1];
		myAngle = Turtle.STARTING_ANGLE;
		penDown = true;
		myTurtleId = id;
		isVisible = true;
		myImagePath = imagePath;
		myImageView = new ImageView(getClass().getClassLoader().getResource(myImagePath).getPath());
		stageWidth = width;
		stageHeight = height;
		
		myImageView.setX(translateX(myX));
		myImageView.setY(translateY(myY));
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
		myX = newVal.doubleValue();
		myImageView.setX(translateX(myX));
	}
	
	protected void changeY(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myY = newVal.doubleValue();
		myImageView.setX(translateX(myX));
	}

	protected void changeAngle(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myAngle = newVal.doubleValue();
	}

	protected void changeId(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
		myTurtleId = newVal.intValue();
	}

	protected void changePen(ObservableValue<? extends Boolean> obs, Boolean oldVal, Boolean newVal) {
		penDown = newVal.booleanValue();
	}

	protected void changeOpacity(ObservableValue<? extends Boolean> obs, Boolean oldVal, Boolean newVal) {
		isVisible = newVal.booleanValue();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}	
	
	private double translateX(double X) {
		return X + stageWidth / 2;
	}
	
	private double translateY(double Y) {
		return Y + stageHeight / 2;
	}

	public Element getTurtleXML(Document doc, Element root) {
		Element xmlElement = doc.createElement(XML_SPRITE);
		XMLReader.createTextElement(doc, root, PreferenceXMLReader.RenderTags.MYX.getTag(), Double.toString(myX));
		XMLReader.createTextElement(doc, root, PreferenceXMLReader.RenderTags.MYY.getTag(), Double.toString(myY));
		XMLReader.createTextElement(doc, root, PreferenceXMLReader.RenderTags.PEN.getTag(), Boolean.toString(penDown));
		XMLReader.createTextElement(doc, root,PreferenceXMLReader.RenderTags.PEN_WIDTH.getTag(), Double.toString(myPenWidth));
		XMLReader.createTextElement(doc, root, PreferenceXMLReader.RenderTags.VISIBILITY.getTag(), Boolean.toString(isVisible));
		XMLReader.createTextElement(doc, root, PreferenceXMLReader.RenderTags.ANGLE.getTag(), Double.toString(myAngle));
		XMLReader.createTextElement(doc, root, PreferenceXMLReader.RenderTags.ID.getTag(), Integer.toString(myTurtleId));
		XMLReader.createTextElement(doc, root, PreferenceXMLReader.RenderTags.PATH.getTag(), myImagePath);
		return xmlElement;
	}
}

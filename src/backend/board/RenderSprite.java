package backend.board;

import java.util.Observable;
import java.util.Observer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import frontend.modules.RenderModule;
import frontend.popups.TurtleView;
import frontend.xml.PreferenceXMLReader;
import frontend.xml.XMLReader;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * @author Albert
 *
 */
public class RenderSprite extends Observable implements iRenderSprite, Observer {
	private static final double SELECTED_DIFFERENCE = 0.5;
	private static final double SELECTED = 1.0;
	private static final String TURTLE = "turtle";
	private static final String XML_SPRITE = "sprite";
	private double myX = Turtle.STARTING_POSITION[0];
	private double myY = Turtle.STARTING_POSITION[1];
	private ImageView myImageView;
	private boolean penDown = true;
	private boolean isSelected = true;
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
		initImage();
	}

	private void initImage() {
		myImageView.setX(myRenderMath.imageX(myX));
		myImageView.setY(myRenderMath.imageY(myY));
		myImageView.setRotate(myImageAngle);
		myImageView.setOnMouseClicked(e -> handleMouseInput(e));
		myImageView.setOnMouseDragged(e -> handleDrag(e));
	}
	
	private void handleMouseInput(MouseEvent event) {
		if(event.getButton().equals(MouseButton.PRIMARY)) {
			selectTurtle();
		} else if(event.getButton().equals(MouseButton.SECONDARY)) {
			TurtleView view = new TurtleView(this);
		}
	}
	
	private void handleDrag(MouseEvent event) {
		setX(myRenderMath.logoX(event.getSceneX()));
		setY(myRenderMath.logoY(event.getSceneY()));
	}
	
	public void stylize() {
		myImageView.getStyleClass().add(TURTLE);
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void selectTurtle() {
		isSelected = !isSelected;
		double isSelectedDouble = isSelected ? 0 : -1;
		myImageView.setOpacity(SELECTED + isSelectedDouble * SELECTED_DIFFERENCE);
	}
	
	@Override
	public double getAngle() {
		return myAngle;
	}

	@Override
	public void setX(double X) {
		myX = X;
		myImageView.setX(myRenderMath.imageX(myX));
		setChangedNotify();
	}
	
	@Override
	public void setY(double newY) {
		myY = newY;
		myImageView.setY(myRenderMath.imageY(myY));
		setChangedNotify();
	}

	@Override
	public void setAngle(double newAngle) {
		myAngle = newAngle;
		myImageAngle = -myAngle;
		myImageView.setRotate(myImageAngle);
		setChangedNotify();
	}

	@Override
	public void setPen(boolean isPenDown) {
		penDown = isPenDown;
		setChangedNotify();
	}

	@Override
	public void setVisibility(boolean isVisible) {
		this.isVisible = isVisible;
		myImageView.setVisible(isVisible);
		setChangedNotify();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Turtle turtle = (Turtle) arg0;
		double oldX = turtle.getMyX();
		double oldY = turtle.getMyY();

		setX(turtle.getMyX());
		setPen(turtle.getPen());

		if(penDown && hasMoved(oldX, oldY)) {
			myRender.drawLine(myTurtleId, oldX, oldY);
		}
		setAngle(turtle.getAngle());
		setVisibility(turtle.getOpacity());	
	}	
	
	public void changeImage(ImageView image) {
		myImageView = image;
		initImage();
	}
	
	private boolean hasMoved(double oldX, double oldY) {
		return ! (oldX == myX && oldY == myY);
	}

	private void setChangedNotify() {
		setChanged();
		notifyObservers();
	}
	
	public RenderMath getMath() {
		return myRenderMath;
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

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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * @author Albert
 *	A Class that handles the rendering of a turtle
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
	private CustomAnimationQueue myAnimationQueue;

	/**
	 * Creates a new RenderSprite
	 * @param id		id of rendersprite
	 * @param imagePath	path of image to be used for rendering
	 * @param width		width of rendering stage
	 * @param height	height of rendering stage
	 * @param render	RenderModule which contains this sprite
	 */
	public RenderSprite(int id, String imagePath, double width, double height, RenderModule render) {
		myRender = render;
		myImageAngle = -myAngle;
		myTurtleId = id;
		myImagePath = imagePath;
		myImageView = new ImageView(imagePath);
		myRenderMath = new RenderMath(width, height, myImageView);

		initImage();
		myAnimationQueue = new CustomAnimationQueue(this, myRender);
	}

	/**
	 * handles the logic of the imageview
	 */
	private void initImage() {
		myImageView.setX(myRenderMath.imageX(myX));
		myImageView.setY(myRenderMath.imageY(myY));
		myImageView.setRotate(myImageAngle);
		myImageView.setOnMouseClicked(e -> handleMouseInput(e));
		myImageView.setOnMouseDragged(e -> handleDrag(e));
	}

	/**
	 * handles user mouse clicks
	 * @param event	the user's mouse click
	 */
	private void handleMouseInput(MouseEvent event) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			selectTurtle();
		} else if (event.getButton().equals(MouseButton.SECONDARY)) {
			TurtleView view = new TurtleView(this);
		}
	}

	/**
	 * handles user mouse drag
	 * @param event	user mouse drag event
	 */
	private void handleDrag(MouseEvent event) {
		setX(myRenderMath.logoX(event.getSceneX() - myRender.getViewModule().getLeftOffset() - myImageView.getBoundsInLocal().getWidth() / 2));
		setY(myRenderMath.logoY(event.getSceneY() - myRender.getViewModule().getTopOffset() - myImageView.getBoundsInLocal().getHeight() / 2));
		setChangedNotify();
	}

	/**
	 * add css styling to this module
	 */
	public void stylize() {
		myImageView.getStyleClass().add(TURTLE);
	}

	/**
	 * @return	whether or not this turtle/rendersprite pair has been selected
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * choose the turtle to execute the commands that come afterwards
	 */
	public void selectTurtle() {
		isSelected = !isSelected;
		double isSelectedDouble = isSelected ? 0 : -1;
		myImageView.setOpacity(SELECTED + isSelectedDouble * SELECTED_DIFFERENCE);
		setChangedNotify();
	}

	@Override
	public double getAngle() {
		return myAngle;
	}

	@Override
	public void setX(double X) {
		readX(X);
		setChangedNotify();
	}

	@Override
	public void setY(double newY) {
		readY(newY);
		setChangedNotify();
	}

	@Override
	public void setAngle(double newAngle) {
		readAngle(newAngle);
		setChangedNotify();
	}

	@Override
	public void setPen(boolean isPenDown) {
		readPen(isPenDown);
		setChangedNotify();
	}

	@Override
	public void setVisibility(boolean isVisible) {
		readVisibility(isVisible);
		setChangedNotify();
	}

	/**
	 * sets x value and image x value without notifying observers
	 * @param X	the x value to set this rendersprite to
	 */
	private void readX(double X) {
		myX = myRenderMath.xTranslate(X);
		myImageView.setX(myRenderMath.imageX(X));
	}

	/**
	 * sets y value and image y value wihtout notifying observers
	 * @param newY	the y value to set this rendersprite to
	 */
	private void readY(double newY) {
		myY = myRenderMath.yTranslate(newY);
		myImageView.setY(myRenderMath.imageY(newY));
	}

	/**
	 * sets angle to newAngle wihtout notifying observers
	 * @param newAngle	the new angle value
	 */
	private void readAngle(double newAngle) {
		myAngle = newAngle;
		myImageAngle = 360 - myAngle;
	}

	/**
	 * sets pen value without notifying observers
	 * @param isPenDown	the new pen value
	 */
	private void readPen(boolean isPenDown) {
		penDown = isPenDown;
	}

	/**
	 * sets the visibility value without notifying observers
	 * @param isVisible	the new visibility value
	 */
	private void readVisibility(boolean isVisible) {
		this.isVisible = isVisible;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Turtle turtle = (Turtle) arg0;
		double oldX = myX;
		double oldY = myY;
		double oldAngle = myAngle;
		boolean oldVisibility = isVisible;
		myX = turtle.getMyX();
		myY = turtle.getMyY();
		readAngle(turtle.getAngle());
		readVisibility(turtle.getOpacity());

		if (hasMoved(turtle, oldX, oldY)) {
			myAnimationQueue.appendTranslationTransition(turtle.getClearScreen());
		}

		myAnimationQueue.appendRotationAnimation(oldAngle, myImageAngle);

		if (oldVisibility != isVisible) {
			myAnimationQueue.appendFadeTransition(oldVisibility, isVisible);
		}
		readPen(turtle.getPen());
		
		if(turtle.getClearScreen()) {
			myRender.clearScreen();
			turtle.setClearScreen(false);
		}
	}

	private boolean hasMoved(Turtle turtle, double oldX, double oldY) {
		return !((turtle.getMyX() == oldX) && (turtle.getMyY() == oldY));
	}

	/**
	 * Change the imageview contained within the rendersprite
	 * @param image	imageview to change to
	 * @return		the old imageview
	 */
	public ImageView changeImage(ImageView image) {
		ImageView oldImageView = myImageView;
		myImageView = image;
		initImage();
		return oldImageView;
	}

	private void setChangedNotify() {
		setChanged();
		notifyObservers();
	}

	@Override
	public RenderMath getMath() {
		return myRenderMath;
	}

	@Override
	public boolean isPenDown() {
		return penDown;
	}

	public double getPenWidth() {
		return myPenWidth;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
	}

	@Override
	public double getX() {
		return myX;
	}

	@Override
	public double getY() {
		return myY;
	}

	@Override
	public int getId() {
		return myTurtleId;
	}

	/**
	 * @return	the imageview contained inside this rendersprite
	 */
	public ImageView getImage() {
		return myImageView;
	}

	/**
	 * Creates an xml element that contains information about this turtle
	 * @param doc	Document to write to
	 * @return		Element that contains the information with the turtle
	 */
	public Element getTurtleXML(Document doc) {
		Element xmlElement = doc.createElement(XML_SPRITE);
		xmlElement.appendChild(
				XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.MYX.getTag(), Double.toString(myX)));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.MYY.getTag(), Double.toString(myY));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.PEN.getTag(), Boolean.toString(penDown));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.PEN_WIDTH.getTag(),
				Double.toString(myPenWidth));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.VISIBILITY.getTag(),
				Boolean.toString(isVisible));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.ANGLE.getTag(), Double.toString(myAngle));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.ID.getTag(), Integer.toString(myTurtleId));
		XMLReader.createTextElement(doc, PreferenceXMLReader.RenderTags.PATH.getTag(), myImagePath);
		return xmlElement;
	}
}

package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.Queue;
import java.util.Stack;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.RenderSprite;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import frontend.modules.InfoInterface;
import frontend.modules.ViewModule;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import backend.control.VariableNode;

/*Manager.java
 * 
 * @author Albert
 * @author Venkat Subramaniam
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager extends Observable implements Observer {
	private Map<String, VariableNode> variables = new HashMap<>();
	private StepThrough myStepThrough;
	private TextParse myParser;
	private double output;
	private ViewModule myViewModule;
	private TurtleCollection myTurtles;
	private InfoInterface myInfoInterface;
	private History myHistory;
	private Properties myLangProperties;
	
	/**
	 * Creates a new Manager 
	 * @param view	ViewModule interacting with the manager
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public Manager(ViewModule view) throws ClassNotFoundException, FileNotFoundException {
		myParser = new TextParse(variables);
		myViewModule = view;
		myHistory = new History();
		myInfoInterface = new InfoInterface(myHistory);
		myStepThrough = new StepThrough();
	}

	/**
	 * Calls on parser to create and execute a new tree from the text and throws error if invalid command
	 * @param text	user inputted text
	 * @return		value of the tree's executed command
	 */
	public double addToHistory(String text) {
		output = -1;
		try {
			output = setAndExecuteCommand(text);
			myHistory.add(myParser.getFormattedSentence(text, myTurtles));
			setChanged();
			notifyObservers();
		} catch(NullPointerException e) {
			throw new NullPointerException();
		}
		return output;
	}
	
	/**
	 * @return	the history as formatted by the info interface
	 */
	public FlowPane getHistory() {
		return myInfoInterface.getHistory();
	}
	
	/**
	 * @param test	Test String inputted by user
	 * @return		the formatted text inputted by the user
	 */
	public TextFlow[] getConsole(String test) {
		return myInfoInterface.getConsole(test, myTurtles);
	}

	/**
	 * A method that initializes a manager's turtles.
	 */
	public void initializeTurtles() {
		List<Turtle> initTurtles = new ArrayList<>();
		List<RenderSprite> myRenders = myViewModule.getRenderModule().getSprites();
		for(RenderSprite rs : myRenders) {
			Turtle newTurtle = new Turtle(rs);
			initTurtles.add(newTurtle);
			rs.addObserver(newTurtle);
		}
		myTurtles = new TurtleCollection(initTurtles, myViewModule.getParent().getScene());
		myTurtles.addObserver(this);
	}
	
	/**
	 * Creates a tree from the user input string and executes it
	 * @param s	User input string
	 * @return	return value of executed tree
	 */
	private double setAndExecuteCommand(String s) {
		myParser.setCommands(s, myTurtles);
		ASTNode tree = myParser.getTree();
		return tree.execute();
	}
	
	/**
	 * @return	the value of the last executed command
	 */
	public double getOutput() {
		return output;
	}
	
	/**
	 * Tells the ViewModule's RenderModule to add a new turtle and adds a turtle to this manager's collection
	 */
	public void addTurtle() {
		RenderSprite rs = myViewModule.getRenderModule().addTurtle();
		addTurtle(rs);
	}
	
	/**
	 * Adds a turtle according to rs to the turtlecollection
	 * @param rs	RenderSprite observing new turtle
	 */
	public void addTurtle(RenderSprite rs) {
		Turtle newTurtle = new Turtle(rs);
		rs.addObserver(newTurtle);
		myTurtles.addTurtle(newTurtle);
	}
	
	/**
	 * Change the language property file used by the parser
	 * @param langProperties	new properties file to be used
	 */
	public void changeLanguage(Properties langProperties) {
		myLangProperties = langProperties;
		myParser.changeLanguage(langProperties);
	}
	
	/**
	 * @return	currently used language properties file
	 */
	public Properties getLangProperties() {
		return myLangProperties;
	}
	
	/**
	 * @return	the variables currently being used in the environment
	 */
	public Map<String, String> getVariables(){
		Map<String, String> vars = new HashMap<>();
		for (String s: variables.keySet()) {
			if(variables.get(s).isNumberVar()) {
				String current = Double.toString(variables.get(s).execute());
				vars.put(s, current);
			}
		}
		return vars;
	}

	@Override
	public void update(Observable o, Object arg) {
		addTurtle();
	}
	
	/**
	 * Undo one step to the state before current
	 */
	public void undo() {
//		myStepThrough.undo(this);
	}
	
	/**
	 * undo an undo
	 */
	public void redo() {
//		myStepThrough.redo(this);
	}

	protected void setTurtleCollection(TurtleCollection turtleCollection) {
		myTurtles = turtleCollection;
	}

	protected void setSpriteState(List<RenderSprite> spriteState) {
		myViewModule.getRenderModule().setSpriteState(spriteState);
	}

	protected void setRenderState(Parent renderState) {
		myViewModule.getRenderModule().setRenderState(renderState);
	}
}

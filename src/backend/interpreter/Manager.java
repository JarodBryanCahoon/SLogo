package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.RenderSprite;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import frontend.modules.InfoInterface;
import frontend.modules.ViewModule;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextFlow;
import backend.abstractSyntaxTree.ASTNode;

/*Manager.java
 * 
 * @author Albert
 * @author Venkat Subramaniam
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager extends Observable {
	private Map<String, List<Object>> myMemory;
	private TextParse myParser;
	private double output;
	private ViewModule myViewModule;
	private TurtleCollection myTurtles;
	private InfoInterface myInfoInterface;
	
	public Manager(String filename, ViewModule view) throws ClassNotFoundException, FileNotFoundException {
		myParser = new TextParse(myMemory, filename);
		myViewModule = view;
		initializeTurtles();
		myInfoInterface = new InfoInterface();
	}
	
	public void addToHistory(String text) {
//		myInfoInterface.addToHistory(text);
//		 my code here
		setChanged();
		notifyObservers();
	}
	
	public FlowPane getHistory() {
		return myInfoInterface.getHistory();
	}
	
	public TextFlow[] getConsole(String test) {
		return myInfoInterface.getConsole(test);
	}

	private void initializeTurtles() {
		List<Turtle> initTurtles = new ArrayList<>();
		List<RenderSprite> myRenders = myViewModule.getRenderModule().getSprites();
		for(RenderSprite rs : myRenders) {
			Turtle newTurtle = new Turtle(rs);
			initTurtles.add(newTurtle);
			rs.addObserver(newTurtle);
		}
		myTurtles = new TurtleCollection(initTurtles);
	}
	
	public void setAndExecuteCommand(String s) {
		myParser.setCommands(s);
		ASTNode tree = myParser.getTree();
		output = tree.execute();
	}
	
	public double getOutput() {
		return output;
	}
	
	public void addTurtle() {
		RenderSprite rs = myViewModule.getRenderModule().addTurtle();
		addTurtle(rs);
	}
	
	public void addTurtle(RenderSprite rs) {
		Turtle newTurtle = new Turtle(rs);
		myTurtles.addTurtle(newTurtle);
	}
	
	private void executeCommands() {
		
	}
}

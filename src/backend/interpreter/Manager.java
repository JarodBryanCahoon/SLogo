package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Properties;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.RenderSprite;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import frontend.modules.InfoInterface;
import frontend.modules.ViewModule;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextFlow;

/*Manager.java
 * 
 * @author Albert
 * @author Venkat Subramaniam
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager extends Observable {
	private TextParse myParser;
	private double output;
	private ViewModule myViewModule;
	private TurtleCollection myTurtles;
	private InfoInterface myInfoInterface;
	private History myHistory;
	
	public Manager(String filename, ViewModule view) throws ClassNotFoundException, FileNotFoundException {
		myParser = new TextParse();
		myViewModule = view;
		myHistory = new History();
		myInfoInterface = new InfoInterface(myHistory);
	}
	
	public void addToHistory(String text) {
		myHistory.add(myParser.getWordsWithSpaces(text, myTurtles));
		
		double output = setAndExecuteCommand(text);
		System.out.println("executed");
		setChanged();
		notifyObservers();
	}
	
	public FlowPane getHistory() {
		return myInfoInterface.getHistory();
	}
	
	public TextFlow[] getConsole(String test) {
		return myInfoInterface.getConsole(test, myTurtles);
	}

	public void initializeTurtles() {
		List<Turtle> initTurtles = new ArrayList<>();
		List<RenderSprite> myRenders = myViewModule.getRenderModule().getSprites();
		for(RenderSprite rs : myRenders) {
			Turtle newTurtle = new Turtle(rs);
			initTurtles.add(newTurtle);
			rs.addObserver(newTurtle);
		}
		myTurtles = new TurtleCollection(initTurtles);
	}
	
	public double setAndExecuteCommand(String s) {
		myParser.setCommands(s, myTurtles);
		ASTNode tree = myParser.getTree();
		return tree.execute();
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
	
	public void changeLanguage(Properties langProperties) {
		
	}
}

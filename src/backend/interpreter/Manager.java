package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.RenderSprite;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import frontend.modules.ViewModule;
import backend.abstractSyntaxTree.ASTNode;

/*Manager.java
 * @author Venkat Subramaniam
 * @author Albert
 * Class that creates and maintains information used to interpret Slogo commands.
 * @version 10.21.17
 */ 

public class Manager {

	private Map<String, List<Object>> myMemory;
	private TextParse myParser;
	private double output;
	private ViewModule myViewModule;
	private TurtleCollection myTurtles;
	
	public Manager(String filename, ViewModule view) throws ClassNotFoundException, FileNotFoundException {
		myParser = new TextParse(myMemory, filename);
		myViewModule = view;
		initializeTurtles();	
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

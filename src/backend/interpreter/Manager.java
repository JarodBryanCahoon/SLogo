package backend.interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.RenderSprite;
import backend.board.Turtle;
import backend.board.TurtleCollection;
import frontend.modules.InfoInterface;
import frontend.modules.ViewModule;
import javafx.scene.layout.FlowPane;
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
	private TextParse myParser;
	private double output;
	private ViewModule myViewModule;
	private TurtleCollection myTurtles;
	private InfoInterface myInfoInterface;
	private History myHistory;
	private Properties myLangProperties;
	
	public Manager(String filename, ViewModule view) throws ClassNotFoundException, FileNotFoundException {
		myParser = new TextParse(variables);
		myViewModule = view;
		myHistory = new History();
		myInfoInterface = new InfoInterface(myHistory);
	}
	
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
		System.out.print("OUTPUT EQUALS : ");
		System.out.println(output);
		return output;
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
		myTurtles = new TurtleCollection(initTurtles, myViewModule.getParent().getScene());
	}
	
	public double setAndExecuteCommand(String s) {
		myParser.setCommands(s, myTurtles);
		ASTNode tree = myParser.getTree();
		return tree.execute();
	}
	
	public double getOutput() {
		System.out.println(output);
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
	
	public void changeLanguage(Properties langProperties) {
		myLangProperties = langProperties;
		myParser.changeLanguage(langProperties);
	}
	
	public Properties getLangProperties() {
		return myLangProperties;
	}
	
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
}

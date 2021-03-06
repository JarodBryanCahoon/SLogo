package frontend.modules;

import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.interpreter.Manager;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.InsetsBuilder;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**Displays history of commands with syntax coloring
 * @author lasia
 *
 */
public class ConsoleHistory extends Module {
	private static final String SCROLLPANE = "ScrollPane";
	private static final String WINDOW = "Window";
	private static final int FADE = 200;
	private static final String GAP = "                                        ";
	private VBox history;
	private ScrollPane historyPane;
	private Manager backend;
	
	public ConsoleHistory(double myWidth, double myHeight, ViewModule view) throws Exception {
		super(myWidth, myHeight, view);
		historyPane.setMinSize(myWidth,myHeight);
		history.setMinSize(myWidth,myHeight);
		backend = view.getManager();
		backend.addObserver(this);
		stylize();
	}

	@Override
	protected Parent createParent() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		return historyPane;
	}
	
	@Override
	public void update(Observable backend, Object arg1) {
		Manager manager = (Manager) backend;
		FlowPane toAdd = manager.getHistory();
		history.getChildren().add(toAdd);
		Text text = new Text(GAP+Double.toString(manager.getOutput()));
		text.getStyleClass().add("Text");
		text.setTextAlignment(TextAlignment.RIGHT);
		
		history.getChildren().add(text);
		fadeIn(toAdd);
		historyPane.setVvalue(1.0);
	}

	private void fadeIn(FlowPane toAdd) {
		FadeTransition ft = new FadeTransition(Duration.millis(FADE),toAdd);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
	}
	
	public void turn(int index, boolean on) {
		if (on)
			history.getChildren().get(index).setStyle("-fx-background-color: green;");
		if (!on)
			history.getChildren().get(index).setStyle("-fx-background-color: black;");			
	}

	private void stylize() {
		history.getChildren().add(new Text(""));
		history.getStyleClass().add(WINDOW);
		historyPane.getStyleClass().add(SCROLLPANE);
		historyPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		
	}

	@Override
	public Element getXMLPreferences(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
}

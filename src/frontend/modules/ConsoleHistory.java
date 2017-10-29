package frontend.modules;

import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import backend.interpreter.Manager;
import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class ConsoleHistory extends Module {
	private VBox history;
	private ScrollPane historyPane;
	private Manager backend;
	
	public ConsoleHistory(double myWidth, double myHeight, ViewModule view) throws Exception {
		super(myWidth, myHeight, view);
		historyPane.setMinSize(myWidth,myHeight);
		history.setMinSize(myWidth-10,myHeight-10);
		stylize();
		backend = view.getManager();
		backend.addObserver(this);
//		history.setOnMouseClicked(e->stylize());		
	}

	@Override
	protected Parent createParent() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		return historyPane;
	}
	
	@Override
	public void update(Observable backend, Object arg1) {
		FlowPane toAdd = ((Manager) backend).getHistory();
		history.getChildren().add(toAdd);
		fadeIn(toAdd);
		stylize();
		historyPane.setVvalue(1.0);
	}

	private void fadeIn(FlowPane toAdd) {
		FadeTransition ft = new FadeTransition(Duration.millis(200),toAdd);
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

	@Override
	public Element getXMLPreferences(Document doc) {

		return null;
	}

	private void stylize() {
		history.getStyleClass().add("Window");
		historyPane.getStyleClass().add("Window");	
	}
}

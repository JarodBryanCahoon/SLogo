package frontend.modules;

import java.util.Observable;
import java.util.Observer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class ConsoleHistory extends Module implements Observer {
	private VBox history;
	private ScrollPane historyPane;
	
	public ConsoleHistory(double myWidth, double myHeight, InfoInterface backend) throws Exception {
		super(myWidth, myHeight);
		historyPane.setMinSize(myWidth,myHeight);
		history.setMinSize(myWidth-10,myHeight-10);
		backend.addObserver(this);
		
		
	}

	@Override
	protected Parent createParent() {
		history = new VBox();
		historyPane = new ScrollPane(history);
		history.getStyleClass().add("inputField");
		historyPane.getStyleClass().add("inputField");
		
		return historyPane;
	}
	
	@Override
	public void update(Observable backend, Object arg1) {
		FlowPane toAdd = ((InfoInterface) backend).getHistory();
		history.getChildren().add(toAdd);
		fadeIn(toAdd);
		
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
		// TODO Auto-generated method stub
		return null;
	}


}

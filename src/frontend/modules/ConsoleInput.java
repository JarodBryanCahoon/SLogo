package frontend.modules;

import javafx.scene.control.TextInputControl;

public class ConsoleInput extends TextInputControl{

public class ConsoleInput extends Module{
	private Group myParent;
	private TextArea inputField;
	private InfoInterface backend;
	private KeyCombination keyComb;
	

	public ConsoleInput(double myWidth,double myHeight,InfoInterface backend) throws Exception{
		super(myWidth, myHeight);
		System.out.println("Console created");
		keyComb = new KeyCodeCombination(KeyCode.ENTER,KeyCombination.SHIFT_DOWN);
		this.backend = backend;
				
		addInputField(myWidth);
		myParent.getChildren().add(inputField);
	}
	

	private void addInputField(double width) {
		inputField = new TextArea();
		inputField.setPrefWidth(width);
		inputField.getStyleClass().add("inputField");
		inputField.setOnKeyPressed(event -> send(event));
		inputField.textProperty().addListener(text ->updateSyntax(text));
	}
	
	private void updateSyntax(Observable in) {
		String text = inputField.textProperty().getValue();
		createText(text);
	}

	private void send(KeyEvent event) {
		String text = inputField.textProperty().getValue();
		if (keyComb.match(event)) {
			backend.addToHistory(text);
			inputField.setText("");
			createText("");
		}
	}

	private void createText(String incomingText) {
		myParent.getChildren().clear();
		myParent.getChildren().add(inputField);
		myParent.getChildren().addAll(backend.getConsole(incomingText));
	}

}

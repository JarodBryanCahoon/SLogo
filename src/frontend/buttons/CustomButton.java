package frontend.buttons;

import frontend.modules.Module;
import javafx.scene.control.Button;

public class CustomButton {
	private ButtonStrategy myStrategy;
	private Button myButton;
	private Module myModule;
	
	public CustomButton(ButtonStrategy strategy, Module module) {
		myStrategy = strategy;
		myModule = module;
	}
	
	public void setOnMouseClicked() {
		myButton.setOnMouseClicked(e -> myStrategy.execute());
	}
}

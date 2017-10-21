package frontend.buttons;

import frontend.modules.Module;
import javafx.scene.control.Button;

public class CustomButton {
	private iButtonStrategy myStrategy;
	private Button myButton;
	private Module myModule;
	
	public CustomButton(iButtonStrategy strategy, Module module) {
		myStrategy = strategy;
		myModule = module;
	}
	
	public void setOnMouseClicked() {
		myButton.setOnMouseClicked(e -> myStrategy.execute());
	}
}

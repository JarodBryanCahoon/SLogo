package frontend.modules;

import javafx.scene.Parent;
import javafx.scene.control.MenuBar;

public class MenuModule extends Module {
	public MenuModule(int width, int height) throws Exception {
		super(width, height);
	}

	@Override
	protected Parent createParent() throws Exception {
		MenuBar myMenu = new MenuBar();
		return null;
	}
}

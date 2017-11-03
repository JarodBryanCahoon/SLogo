package frontend.menus.strategies;

import frontend.modules.ViewModule;

/**
 * A Class that allows the user to add a new turtle
 * @author Albert
 *
 */
public class NewTurtle extends MenuItemStrategy {

	/**
	 * Creates a new NewTurtle
	 * @param module	ViewModule associated with strategy
	 */
	public NewTurtle(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		this.getView().getManager().addTurtle();
	}

}

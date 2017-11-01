package frontend.menus.strategies;

import java.awt.Desktop;
import java.net.URI;

import exceptions.ErrorMessage;
import frontend.modules.ViewModule;

/**
 * A MenuItem button that, on click, allows the user to access a command help page
 * @author Albert
 *
 */
public class Help extends MenuItemStrategy {

	private static final String HELP_WEBSITE = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";

	/**
	 * Creates a new Help 
	 * @param module	ViewModule with which this is associated
	 */
	public Help(ViewModule module) {
		super(module);
	}

	@Override
	public void execute() {
		try {
            Desktop.getDesktop().browse(new URI(HELP_WEBSITE));
		} catch (Exception e) {
			ErrorMessage eMessage = new ErrorMessage("Website could not be displayed");
			eMessage.show();
		}
	}

}

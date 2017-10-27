package frontend.menus.strategies;

import exceptions.ErrorMessage;
import frontend.modules.ViewModule;
import frontend.xml.ConfigReader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewWindow extends MenuItemStrategy {
	private static final String configFileName = "config.xml";
	public NewWindow(ViewModule module) {
		super(module);
	}
	
	@Override
	public void execute() {
		Stage s = new Stage();
		try {
			System.out.println(getClass().getClassLoader().getResource(configFileName));

			ConfigReader configReader = new ConfigReader(getClass().getClassLoader().getResource(configFileName).getPath());
			ViewModule view = new ViewModule(configReader.getWidth(), configReader.getHeight());
			
			Scene scene = new Scene(view.getParent());
			s.setScene(scene);
			s.setTitle(configReader.getTitle());
			s.show();
		} catch (Exception e) {
			ErrorMessage eMessage = new ErrorMessage("Could Not Create New Window");
			eMessage.show();
		}
	}

}

package frontend.menus.strategies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import exceptions.ErrorMessage;
import frontend.modules.ViewModule;
import frontend.popups.PopUp;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChangeLanguage extends MenuItemStrategy {
	private static final String UNFLAG_PATH = "/resources/style/unflag.gif";
	private static final String LANGUAGE_PATH = "Languages.txt";
	private final String PREFIX_PATH = "src/resources/languages/";
	private final String PROPERTIES_SUFFIX = ".properties";
	private List<String> languageLabels;
	private ChoiceBox<String> myChoiceBox;
	private PopUp myPopUp;
	private boolean newWindow;
	private Stage myStage;
	public ChangeLanguage(ViewModule view) {
		super(view);
		newWindow = false;
	}
	
	public ChangeLanguage(Stage s) throws Exception {
		super(new ViewModule(0, 0));
		newWindow = true;
		myStage = s;
	}
	
	private Parent createParent() {		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		myChoiceBox = new ChoiceBox<>();
		myChoiceBox.setTooltip(new Tooltip("Select Language"));
		
		languageLabels = new ArrayList<>();

		readLanguageLabels(languageLabels);     
		myChoiceBox.getItems().addAll(languageLabels);
		myChoiceBox.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> changeLanguage(options, oldValue, newValue));
		hBox.getChildren().add(new ImageView(UNFLAG_PATH));
		hBox.getChildren().add(myChoiceBox);
		return hBox;
	}

	private void changeLanguage(ObservableValue options, Object oldValue, Object newValue) {
		String newLanguage = (String) newValue;
		Properties languageProperties = new Properties();
		InputStream input;

		try {
			input = new FileInputStream(PREFIX_PATH + newLanguage + PROPERTIES_SUFFIX);
			languageProperties.load(input);
			if(newWindow) {
				try {
					NewWindow init = new NewWindow(myStage, languageProperties);
					init.execute();
				} catch (Exception e) {
					ErrorMessage eMessage = new ErrorMessage("Could not initiate new windodw");
					eMessage.show();
				}
			} else {
				getView().changeLanguage(languageProperties);
			}
		} catch (IOException ex) {
			ErrorMessage eMessage = new ErrorMessage("Could Not Load Properties File");
			eMessage.show();
		}
		myPopUp.hide();
	}

	private void readLanguageLabels(List<String> languageLabels) {
		try {
	        Scanner input = new Scanner(PREFIX_PATH + LANGUAGE_PATH);
	        File file = new File(input.nextLine());
	        input = new Scanner(file);

	        while (input.hasNextLine()) {
	            String line = input.nextLine();
	            languageLabels.add(line);
	        }
	        
		} catch (IOException e) {
			ErrorMessage eMessage = new ErrorMessage("No Language File Found");
			eMessage.show();
		}
	}
	
	@Override
	public void execute() {
		myPopUp = new PopUp(createParent(), "Change Language");
		
	}

}

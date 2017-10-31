import java.util.ResourceBundle;

import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.board.interfacemovement.SomeParamTurtle;
import frontend.xml.ColorReader;
import javafx.scene.Scene;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenColor extends SomeParamTurtle {
	public static final String RENDER = "Render";
	private ResourceBundle myColors = ResourceBundle.getBundle("TBD");
	private String myColor;
	public PenColor(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) {
		// TODO Auto-generated method stub
		ColorReader cr = new ColorReader(ColorReader.CSSPATH);
		cr.setColor(RENDER, 1, Double.toString(super.getChildren().get(0).execute()));
		Scene thisScene = this.getTurtles().getScene();
		thisScene.getStylesheets().clear();
		thisScene.getStylesheets().add(ColorReader.CSSPATH + ColorReader.CSSFILENAME);
		return 0;
	}
	
//String should always be render
//index 1 for pen color
//background index 0

//Arg 3 string which has to be in hex format
}
package backend.board.vischanger;

import java.io.IOException;
import java.util.ResourceBundle;

import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.board.interfacemovement.SomeParamTurtle;
import frontend.xml.ColorReader;
import javafx.scene.Scene;

/**
 * @author Jarod Cahoon, Lasia Lo
 *
 */
public class SetPenColor extends SomeParamTurtle {
	public static final String RENDER = "Render";
//	private ResourceBundle myColors = ResourceBundle.getBundle("");
	private String myColor;
	
	public SetPenColor(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) throws IOException {
		// TODO Auto-generated method stub
		ColorReader cr = new ColorReader(ColorReader.CSSPATH+"Colors.xml");
		cr.setColor(RENDER, 3, Double.toHexString(super.getChildren().get(0).execute()));
		Scene thisScene = this.getTurtles().getScene();
		thisScene.getStylesheets().clear();
		thisScene.getStylesheets().add(ColorReader.CSSPATH + ColorReader.CSSFILENAME);
		return 0;
	}
}
import java.util.ResourceBundle;

import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.board.interfacemovement.SomeParamTurtle;
import frontend.xml.ColorReader;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenColor extends SomeParamTurtle {
	private ResourceBundle myColors = ResourceBundle.getBundle("TBD");
	private String myColor;
	public PenColor(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) {
		// TODO Auto-generated method stub
		ColorReader cr = new ColorReader(ColorReader.CSSPATH);
		return 0;
	}
	
//String should always be render
//index 1 for pen color
//background index 0

//Arg 3 string which has to be in hex format
}
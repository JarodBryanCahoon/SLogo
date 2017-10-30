import java.util.ResourceBundle;

import backend.board.Turtle;
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
	public PenColor(String s) {
		myColor = s;
	}

	@Override
	public double act(Object obj) {
		ColorReader cr = (ColorReader)obj;
		cr.setColor("Render", 1, myColor);
		return 0;
	}

	@Override
	public double act(Turtle turt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//String should always be render
//index 1 for pen color
//background index 0

//Arg 3 string which has to be in hex format
}
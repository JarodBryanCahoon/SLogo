package resources.style;

import java.io.IOException;

import frontend.modules.ColorPick;
import frontend.xml.ColorReader;

public class ColorPickTester {
	
	public static void main(String[]args) throws IOException {
		ColorReader myReader = new ColorReader("C:\\Users\\lasia\\Documents\\workspace\\slogo_team02\\src\\resources\\style\\Colors.xml"); 
		ColorPick cp = new ColorPick(myReader,"bleh","bleah");
		cp.changecolor();
		
	}
}

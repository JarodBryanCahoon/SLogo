package frontend.modules;

import frontend.xml.ColorReader;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ColorPick {
	private ColorPicker colorpick;
	private ColorReader myReader;
	private String name;
	private String property;
	
	public ColorPick(ColorReader myReader, String title, String property) {
		this.name = title;
		this.property = property;
		this.myReader = myReader;
		colorpick = new ColorPicker(Color.valueOf(property));
		colorpick.setOnAction(e->changecolor());
		colorpick.getStyleClass().add("ColorPicker");
	}

	public void changecolor() {
		System.out.println(name);
		System.out.println(myReader.getNodeString(name));
		System.out.println(property);
//		System.out.println(colorpick.getValue());
//		myReader.setColor("bleh","b;e");
	}
	public ColorPicker getColorPicker() {
		return colorpick;
	}

}

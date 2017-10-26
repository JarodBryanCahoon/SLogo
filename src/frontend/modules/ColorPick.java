package frontend.modules;

import frontend.xml.ColorReader;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ColorPick {
	private ColorPicker colorpick;
	private ColorReader myReader;
	private String name;
	private String color;
	
	public ColorPick(ColorReader myReader, String name, String color) {
		this.name = name;
		this.color = color;
		this.myReader = myReader;
		colorpick = new ColorPicker(Color.valueOf(color));
		colorpick.setOnAction(e->changecolor());
		colorpick.getStyleClass().add("ColorPicker");
	}

	public void changecolor() {
		System.out.println(name);
		System.out.println(color);
//		System.out.println(colorpick.getValue());
		myReader.setColor("bleh","b;e");
	}
	public ColorPicker getColorPicker() {
		return colorpick;
	}

}

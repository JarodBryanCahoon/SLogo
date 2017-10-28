package frontend.modules;

import frontend.xml.ColorReader;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ColorPick {
	private ColorPicker colorpick;
	private ColorReader myReader;
	private String name;
	private int index;
	
	public ColorPick(ColorReader myReader, String title,int index) {
		this.name = title;
		this.index = index;
		this.myReader = myReader;
		String color = myReader.getChildNode(name,index);
		colorpick = new ColorPicker(Color.valueOf(color));
		colorpick.setOnAction(e->changecolor());
		colorpick.getStyleClass().add("ColorPicker");
	}

	public void changecolor() {
		System.out.println(name);
		System.out.println(myReader.getNodeListString(name));
		System.out.println(myReader.getChildNode(name,index));
//		System.out.println(colorpick.getValue());
		String color = colorpick.getValue().toString();
		myReader.setColor(name,index,color);
	}
	public ColorPicker getColorPicker() {
		return colorpick;
	}

}

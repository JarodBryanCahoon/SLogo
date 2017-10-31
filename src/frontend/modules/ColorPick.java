package frontend.modules;

import java.io.IOException;

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
		colorpick.setOnAction(e->{
			try {
				changecolor();
			} catch (IOException e1) {
			}
		});
		colorpick.getStyleClass().add("ColorPicker");
	}

	public void changecolor() throws IOException {
		String color = colorpick.getValue().toString();
		color = "#" +color.substring(2);
		myReader.setColor(name,index,color);
	}
	
	public ColorPicker getColorPicker() {
		return colorpick;
	}

}

package frontend.xml;

import exceptions.ErrorMessage;

public class ColorSetter {
	
	
	public void setColor(String name, String color) {
		try {
			getElement().getElementsByTagName(name).item(0).getChildNodes().item(1).setTextContent(color);
		}
		catch (Exception NullPointerException) {
			ErrorMessage eMessage = new ErrorMessage("color not found");
			eMessage.show();
		}
		getElement().getElementsByTagName("Variable").item(0).getChildNodes().item(1);
	}
}

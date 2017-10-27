package backend.board.vischanger;

import javafx.scene.paint.Color;

public class SetPenColor implements VisModifier{

	private Color myColor;
	public SetPenColor(Object index) {
		myColor =  /*ResourceBundle.get()*/(Integer)index;
		//TODO: change color to set to resource bundle
		
	}

	@Override
	public Object act(Object obj) {
		obj = (FrontEndManager)obj;
		obj.setPenColor(myColor);
	}
}

package backend.board.vischanger;

import javafx.scene.paint.Color;

public class SetPenSize implements VisModifier{

	private Double mySize;
	public SetPenSize(Object index) {
		mySize =  /*ResourceBundle.get()*/(Double)index;
		//TODO: change color to set to resource bundle
		
	}

	@Override
	public Object act(Object obj) {
		obj = (FrontEndManager)obj;
		obj.setPenSize(mySize);
	}
}

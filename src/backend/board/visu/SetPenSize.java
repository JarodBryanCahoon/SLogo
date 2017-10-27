package backend.board.visu;

import javafx.scene.paint.Color;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetPenSize implements FrontendVisualize{
	private Double mySize;
	public SetPenSize(Double i) {
		mySize = /*ResourceFile.get*/i;
	}

	@Override
	public Object act(Object obj) {
		obj = (FrontEndManager)obj;
		obj.setPenSize(mySize);
		return mySize;
	}
}

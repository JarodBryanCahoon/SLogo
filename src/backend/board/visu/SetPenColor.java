package backend.board.visu;

import javafx.scene.paint.Color;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetPenColor implements FrontendVisualize{
	private Color myColor;
	public SetPenColor(Integer i) {
		myColor = /*ResourceFile.get*/i;
	}

	@Override
	public Object act(Object obj) {
		obj = (FrontEndManager)obj;
		obj.changePenColor(myColor);
		return myColor;
	}
}

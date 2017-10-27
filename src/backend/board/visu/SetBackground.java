package backend.board.visu;

import javafx.scene.paint.Color;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetBackground implements FrontendVisualize{
	private Color myColor;
	public SetBackground(Integer i) {
		myColor = /*ResourceFile.get*/i;
	}

	@Override
	public Object act(Object obj) {
		obj = (FrontEndManager)obj;
		obj.changeBackground(myColor);
		return myColor;
	}
}

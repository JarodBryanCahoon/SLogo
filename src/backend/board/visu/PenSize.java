package backend.board.visu;

import javafx.scene.paint.Color;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenSize implements FrontendVisualize{
	public SetBackground() {
	}

	@Override
	public Object act(Object obj) {
		obj = (FrontEndManager)obj;
		return obj.getPenSize();
	}
}

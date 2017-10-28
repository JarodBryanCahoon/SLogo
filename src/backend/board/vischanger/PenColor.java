import javafx.scene.paint.Color;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class PenColor implements VisModifier {
	public PenColor() {
	}

	@Override
	public Object act(Object obj) {
		return obj.getBackgroundColor();
	}
	

}
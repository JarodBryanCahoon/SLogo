package backend.board.vischanger;


/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Shape implements VisModifier {
	public Shape() {
	}

	@Override
	public Object act(Object obj) {
		return obj.getPenShape();
	}
	

}
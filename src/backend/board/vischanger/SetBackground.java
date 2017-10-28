package backend.board.vischanger;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class SetBackground implements VisModifier {
	private Color myColor;
	public SetBackground(Object index) {
		myColor =  /*ResourceBundle.get()*/(Integer)index;
		//TODO: change color to set to resource bundle
		
	}

	@Override
	public Object act(Object obj) {
		obj = (FrontEndManager)obj;
		obj.setBackground(myColor);
	}
	

}

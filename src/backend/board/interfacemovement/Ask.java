package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.control.ListNode;

/**
 * Implements the Ask command 
 * @author Albert
 */
public class Ask extends SomeParamTurtle {

	/**
	 * Creates a new Ask Node 
	 * @param turtles	TurtleCollection to execute over
	 */
	public Ask(TurtleCollection turtles) {
		super(turtles);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double act(Turtle turt) throws IOException {
		ListNode turtleListNode = (ListNode) super.getChildren().get(0);
		String[] turtleIds = turtleListNode.getContents();
		boolean turtleSelected = turt.isSelected();
		
		for(int i = 0; i < turtleIds.length; i++) {
			int id = Integer.parseInt(turtleIds[i]);
			while(!getTurtles().turtleExistsById(id)) {
				getTurtles().createTurtle();
			}
			
			if(turt.getId() == id) {
				turt.selectTurtle(true);
			}
		}
		
		double returnValue = super.getChildren().get(1).execute();
		turt.selectTurtle(turtleSelected);
		return returnValue;
	}

}

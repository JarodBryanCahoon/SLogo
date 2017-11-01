package backend.board.interfacemovement;

import java.io.IOException;
import java.util.List;

import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.control.ListNode;

/**
 * Implements the Tell command
 * 
 * @author Albert
 */
public class Tell extends SomeParamTurtle {
	private boolean init = false;

	/**
	 * Creates a new Tell Command
	 * 
	 * @param turtles
	 */
	public Tell(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) throws IOException {
		ListNode turtleListNode = (ListNode) super.getChildren().get(0);
		String[] myTurtleIds = turtleListNode.getContents();

		if (init) {
			init = false;
			List<Turtle> myTurtles = getTurtles().getTurtles();
			for (Turtle t : myTurtles) {
				t.selectTurtle(false);
			}
		}

		for (int i = 0; i < myTurtleIds.length; i++) {
			int id = Integer.parseInt(myTurtleIds[i]);
			while (!getTurtles().turtleExistsById(id)) {
				getTurtles().createTurtle();
			}

			if (turt.getId() == id) {
				turt.selectTurtle(true);
			}
		}

		return Double.parseDouble(myTurtleIds[myTurtleIds.length - 1]);
	}
}

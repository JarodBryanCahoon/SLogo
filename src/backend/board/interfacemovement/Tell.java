package backend.board.interfacemovement;

import java.io.IOException;

import backend.board.Turtle;
import backend.board.TurtleCollection;
import backend.control.ListNode;

public class Tell extends SomeParamTurtle {
	public Tell(TurtleCollection turtles) {
		super(turtles);
	}

	@Override
	public double act(Turtle turt) throws IOException {
		ListNode turtleListNode = (ListNode) super.getChildren().get(0);
		String[] myTurtleIds = turtleListNode.getContents();
//		System.out.println("here");
		turt.selectTurtle(false);
		for(int i = 0; i < myTurtleIds.length; i++) {
			int id = Integer.parseInt(myTurtleIds[i]);
			while(!getTurtles().turtleExistsById(id)) {
//				System.out.println("Does not exist");
				getTurtles().createTurtle();
			}
			
			if(turt.getId() == id) {
				turt.selectTurtle(true);
			}
			
		}		
		
		return super.getChildren().get(1).execute();
	}
}

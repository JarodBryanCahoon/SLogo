package backend.board.interfacemovement;

import java.util.List;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public interface Node{
	public double execute();
	public void setChildren(Node n);
}

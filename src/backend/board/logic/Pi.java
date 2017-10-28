package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;
import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Pi implements InactiveInterface{
	
	public Pi() {
	}
	
	public double act() {
		return Math.PI;
	}
}
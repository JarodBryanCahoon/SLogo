package backend.abstractSyntaxTree;

import java.util.List;

import backend.board.Turtle;
/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public interface ASTNode{
	public double execute();
	public void setChildren(ASTNode n);
}

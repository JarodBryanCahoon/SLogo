package backend.abstractSyntaxTree;

/**
 * 
 * @author Jarod Cahoon, Venkat Subramaniam
 *
 */
public interface ASTNode{
	public double execute();
	public void setChildren(ASTNode n);
}

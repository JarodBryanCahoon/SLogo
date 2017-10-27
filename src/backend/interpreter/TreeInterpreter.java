package backend.interpreter;

import backend.abstractSyntaxTree.ASTNode;

public class TreeInterpreter {
	private ASTNode tree;
	public TreeInterpreter(ASTNode ast) {
		tree = ast;
	}

}

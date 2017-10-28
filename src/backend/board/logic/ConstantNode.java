package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;

public class ConstantNode extends NoParamMath{
	double myValue;
	public ConstantNode(double d) {
		myValue = d;
	}
	@Override
	public double execute() {
		return myValue;
	}
	
}

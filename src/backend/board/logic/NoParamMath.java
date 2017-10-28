package backend.board.logic;

import backend.abstractSyntaxTree.ASTNode;


public class NoParamMath implements ASTNode{
	
	public NoParamMath() {
		
	}
	@Override
	public double execute() {
		return 0;
	}

	@Override
	public void setChildren(ASTNode n) {
		//this hopefully will never be reached
		
	}
	}


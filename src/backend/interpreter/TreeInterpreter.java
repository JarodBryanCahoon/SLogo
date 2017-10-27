package backend.interpreter;

import backend.abstractSyntaxTree.ASTNode;
import backend.abstractSyntaxTree.Expression;
import backend.abstractSyntaxTree.VariableExp;

public class TreeInterpreter {
//	private ASTNode tree;
	private static final String OPERATOR = "command";
	private static final String ARGUMENT = "argument";
	private static final String VARIABLE = "variable"
;	private double value1 = Double.MIN_VALUE;
	private double value2 = Double.MIN_VALUE;
	private String var;
//	private boolean operated=false;
	
	public TreeInterpreter(ASTNode ast) {
		execute(ast);
	}
	
	private void execute(ASTNode root) {
		if(root == null) {
			return;
		}
		execute(root.getLeft());
		execute(root.getRight());
		//do something to root
		if (root.getExpression().getKind().equals(ARGUMENT)) {
			if(value1==Double.MIN_VALUE) {
				value1 = root.getExpression().getVal();
			}
			if (value2==Double.MIN_VALUE) {
				value2 = root.getExpression().getVal();
			}
		}
		else if(root.getExpression().getKind().equals(VARIABLE)) {
			VariableExp exp = (VariableExp) root.getExpression();
			var = exp.getName();
		}
		else if (root.getExpression().getKind().equals(OPERATOR)) {
			Class c = Class.forName(root.getExpression().getName());
			if(value1==Double.MIN_VALUE &&value2==Double.MIN_VALUE) {
				
			}
		}
	
	}

}

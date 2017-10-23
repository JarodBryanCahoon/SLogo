package backend.interpreter;

import backend.abstractSyntaxTree.Expression;
import backend.abstractSyntaxTree.NoneOperatorExp;
import backend.abstractSyntaxTree.MonoOperatorExp;
import backend.abstractSyntaxTree.DuoOperatorExp;
import backend.abstractSyntaxTree.PolyOperatorExp;
public class CommandNumber {
	private Expression command;
	private int number;
	private boolean list;
//	private String kind = "NoneOperatorExp";
	
	
	public CommandNumber(Expression e) {
		command = e;
	}
	
	public Expression getCommand() {
		return command;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void increment() {
		number++;
//		if(number ==1) {
//			kind = "MonoOperatorExp";
//			
//		}
//		if(number==2) {
//			kind = "DuoOperatorExp";
//		}
//		if (number>2) {
//			//this seems poorly thought out tbh - V
//		}
	}
	
	public void setbool() {
		list=true;
	}
	
	public void setExpression() {
		if(!list) {
		if (number==0) {
			command = (NoneOperatorExp) command;
		}
		if (number==1) {
			command = (MonoOperatorExp) command;
		}
		if (number==2) {
			command = (DuoOperatorExp) command;
		}
	}
		else {
			command = (PolyOperatorExp) command;
		}
	}
}

package backend.AbstractSyntaxTree;

import java.util.Collection;

public class PolyOperatorExp<T> extends OperatorExp{
	private Collection<T> args;
	public PolyOperatorExp(String s) {
		super(s);
	}
	
	public void setArgs(Collection<T> c) {
		args = c;
	}
	
	public void operate() {
		//unnecessary?
	}
	

}

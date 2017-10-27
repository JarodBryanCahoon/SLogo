package backend.abstractSyntaxTree;

import java.util.Collection;

public class PolyOperatorExp extends OperatorExp{
	private Collection<String> args;
	public PolyOperatorExp(String s) {
		super(s);
	}
	
	protected void setArgs(Collection c) {
		args = c;
	}
	
	protected void operate() {
		//unnecessary?
	}

}

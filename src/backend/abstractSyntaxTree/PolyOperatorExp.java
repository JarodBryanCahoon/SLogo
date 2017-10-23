package backend.abstractSyntaxTree;

import java.util.Collection;

public class PolyOperatorExp extends OperatorExp{
	private Collection<String> args;
	public PolyOperatorExp(String s) {
		super(s);
	}
	
	public void setArgs(Collection c) {
		args = c;
	}
	
	public void operate() {
		//unnecessary?
	}

}

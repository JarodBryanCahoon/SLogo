package backend.abstractsyntaxtree;

public abstract class OperatorExp extends Expression{
	String name;
	public OperatorExp(String s) {
		name=s;
	}
}

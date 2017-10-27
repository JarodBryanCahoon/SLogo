package backend.abstractSyntaxTree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 
 * @author Venkat Subramaniam/Jarod Cahoon
 *
 */
public class VariableExp extends Expression{
	private String kind = "variable";
	private double value;
	private String name;
	
	public VariableExp(String s) {
		name = s;
	}
	
	protected void setVal(double d) {
		value  =d;
	}
	
	public double getVal() {
		return value; 
	}

	@Override
	public String getKind() {
		// TODO Auto-generated method stub
		return kind;
	}
	
	public String getName() {
		return name;
		
	}
}

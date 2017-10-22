package backend.abstractSyntaxTree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VariableExp extends Expression{
	String name;
	double val1;
	int val2;
	boolean type;
	
	public VariableExp(String s) {
		this.name = s;
	}
	
	public void setVal(Expression e) throws NoSuchMethodException, SecurityException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = e.getClass().getMethod("getVal", null);
		m.setAccessible(true);
		if (e.getClass().getName().equals("DoubleExp")){
			type=true;
			val1 = (double) m.invoke(e, null);
		}
		else {
			val2 = (int) m.invoke(e, null);
		}
	}
	
	public double getVal() {
		if(type) {
			return this.val1;
		}
		return this.val2;
	}
}

package backend.abstractSyntaxTree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VariableExp extends Expression{
	private String name;
	private double val1;
	private int val2;
	private boolean type;
	
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

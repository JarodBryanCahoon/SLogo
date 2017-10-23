package backend.abstractSyntaxTree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 
 * @author Venkat Subramaniam/Jarod Cahoon
 *
 */
public class VariableExp extends Expression{
	private String name;
	private Number value;
	
	public VariableExp(String s) {
		this.name = s;
	}
	
	public void setVal(Expression e) throws NoSuchMethodException, SecurityException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = e.getClass().getMethod("getVal", null);
		m.setAccessible(true);
		if (e.getClass().getName().equals("DoubleExp")){
			value = new Double((double)m.invoke(e, null));
		}
		else {
			value = new Integer((int) m.invoke(e, null));
		}
	}
	
	public Number getVal() {
		return value; 
	}
}

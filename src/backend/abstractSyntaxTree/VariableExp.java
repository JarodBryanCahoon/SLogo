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
	private Number value;
	
	public VariableExp(String s) {
	}
	
	protected void setVal(Expression e) throws NoSuchMethodException, SecurityException, 
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
	
	protected Number getVal() {
		return value; 
	}

	@Override
	public String getKind() {
		// TODO Auto-generated method stub
		return kind;
	}
}

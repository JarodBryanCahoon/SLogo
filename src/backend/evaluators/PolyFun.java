package backend.evaluators;

import java.util.Collection;

@FunctionalInterface
public interface PolyFun<T> {
	public double evaluate(Collection<T> c);
}
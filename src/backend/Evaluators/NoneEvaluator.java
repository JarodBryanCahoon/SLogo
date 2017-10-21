package backend.Evaluators;

public class NoneEvaluator implements NoneFun {

	NoneFun none;
	public NoneEvaluator(NoneFun n) {
		none = n;
	}
	
	@Override
	public double evaluate() {
		return none.evaluate();
	}
	
}

package backend.Evaluators;

public class DuoEvaluator implements DuoFun{
	DuoFun duo;
	
	public DuoEvaluator(DuoFun d) {
		duo =d;
	}

	@Override
	public double evaluate(double d1, double d2) {
		return duo.evaluate(d1, d2);
	}
}

package backend.evaluators;

public class MonoEvaluator implements MonoFun {
	MonoFun mono;
	
	public MonoEvaluator(MonoFun m) {
		mono =m;
	}

	@Override
	public double evaluate(double d) {
		return mono.evaluate(d);
	}

}

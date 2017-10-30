package backend.control;

public class If extends ControlNode{

	public If() {
		super();
	}
	
	@Override
	public double execute() {
		if (super.getChildren().get(0).execute()!=0) {
			return super.getChildren().get(1).execute();
		}
		return 0;
	}

}

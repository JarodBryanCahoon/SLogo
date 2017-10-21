package backend.interpreter;

public class Word {
	private String myName;
	private String myType;
	
	public Word(String s) {	
		myName = s.toLowerCase();
		determineType();
	}
	
	private void determineType() {
		if(myName.matches("^-?[0-9]+\\.?[0-9]*$")){
			myType = "constant";
		}
		else if(myName.matches("^:[a-zA-Z_]+$")) {
			myType = "variable";
		}
		else if(myName.matches("^[a-zA-Z_]+(\\?)?$")) {
			myType = "command";
		}
		else if (myName.matches("^#.*")) {
			myType = "comment";
		}
		
		else {
			myType = "invalid";
		}
	}
}

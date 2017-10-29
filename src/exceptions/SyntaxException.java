package exceptions;

public class SyntaxException extends RuntimeException {
	public SyntaxException(Throwable exception) {
		super(exception);
	}
	
	public SyntaxException() {
		super();
	}
}

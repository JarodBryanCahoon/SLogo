package exceptions;

/**
 * A class that throws when a user puts in syntactically incorrect text
 * @author Albert
 *
 */
public class SyntaxException extends RuntimeException {
	/**
	 * Creates a new Syntax Exception from a throwable
	 * @param exception	throwable that caused the syntax exception
	 */
	public SyntaxException(Throwable exception) {
		super(exception);
	}
	
	/**
	 * Creates a new syntax exception
	 */
	public SyntaxException() {
		super();
	}
}

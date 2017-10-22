package exceptions;

public class XMLException extends RuntimeException {
	/**
	 * Creates a new XMLException
	 * @param exception	Throwable that caused the exception
	 */
	public XMLException(Throwable exception) {
		super(exception);
	}

	/**
	 * Creates a new XMLException
	 */
	public XMLException() {
	}
}
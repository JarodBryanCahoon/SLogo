package exceptions;

/**
 * A Class that is thrown during xml reading errors
 * @author Albert
 *
 */
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

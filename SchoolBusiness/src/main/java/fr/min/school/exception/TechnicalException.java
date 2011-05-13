/**
 * 
 */
package fr.min.school.exception;

/**
 * @author minimoi
 * 
 */
public class TechnicalException extends Exception {

	/**
     * 
     */
	private static final long serialVersionUID = 5881097185271083172L;

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            the message of the exception
	 */
	public TechnicalException(final String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            the message of the exception
	 * @param cause
	 *            the cause of the exception
	 */
	public TechnicalException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * 
	 * @param cause
	 *            the cause of the exception
	 */
	public TechnicalException(final Throwable cause) {
		super(cause);
	}

}

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

	public TechnicalException(final String message) {
		super(message);
	}

	public TechnicalException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public TechnicalException(final Throwable cause) {
		super(cause);
	}

}

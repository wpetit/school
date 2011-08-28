/**
 * 
 */
package fr.min.school.exception;

/**
 * 
 * @author Wilfried Petit
 * 
 */
public class TechnicalException extends Exception {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 6124396583697913275L;

	/**
	 * Constructor.
	 */
	public TechnicalException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 */
	public TechnicalException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor.
	 */
	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

}

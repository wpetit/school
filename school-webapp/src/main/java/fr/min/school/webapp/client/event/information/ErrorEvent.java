/**
 * 
 */
package fr.min.school.webapp.client.event.information;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class ErrorEvent extends GwtEvent<ErrorEventHandler> {
	public static Type<ErrorEventHandler> TYPE = new Type<ErrorEventHandler>();
	private final Throwable throwable;

	public ErrorEvent(Throwable throwable) {
		this.throwable = throwable;
	}

	@Override
	public Type<ErrorEventHandler> getAssociatedType() {
		return ErrorEvent.TYPE;
	}

	@Override
	protected void dispatch(ErrorEventHandler handler) {
		handler.onError(this);
	}

	/**
	 * Return the ErrorEvent throwable.
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}

}
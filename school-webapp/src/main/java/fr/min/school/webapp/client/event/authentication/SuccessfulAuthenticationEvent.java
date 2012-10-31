/**
 * 
 */
package fr.min.school.webapp.client.event.authentication;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class SuccessfulAuthenticationEvent extends
		GwtEvent<SuccessfulAuthenticationEventHandler> {
	public static Type<SuccessfulAuthenticationEventHandler> TYPE = new Type<SuccessfulAuthenticationEventHandler>();
	private final int userId;

	public SuccessfulAuthenticationEvent(int userId) {
		this.userId = userId;
	}

	@Override
	public Type<SuccessfulAuthenticationEventHandler> getAssociatedType() {
		return SuccessfulAuthenticationEvent.TYPE;
	}

	@Override
	protected void dispatch(SuccessfulAuthenticationEventHandler handler) {
		handler.onSuccessfulAuthentication(this);
	}

	/**
	 * Return the SuccessfulAuthenticationEvent userId.
	 * 
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
}
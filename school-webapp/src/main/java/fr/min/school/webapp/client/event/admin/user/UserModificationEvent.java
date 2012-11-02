/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class UserModificationEvent extends
		GwtEvent<UserModificationEventHandler> {
	public static Type<UserModificationEventHandler> TYPE = new Type<UserModificationEventHandler>();

	@Override
	public Type<UserModificationEventHandler> getAssociatedType() {
		return UserModificationEvent.TYPE;
	}

	@Override
	protected void dispatch(UserModificationEventHandler handler) {
		handler.onUserModification(this);
	}

}
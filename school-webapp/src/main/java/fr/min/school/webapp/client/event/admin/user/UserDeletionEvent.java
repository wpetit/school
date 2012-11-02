/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class UserDeletionEvent extends GwtEvent<UserDeletionEventHandler> {
	public static Type<UserDeletionEventHandler> TYPE = new Type<UserDeletionEventHandler>();

	@Override
	public Type<UserDeletionEventHandler> getAssociatedType() {
		return UserDeletionEvent.TYPE;
	}

	@Override
	protected void dispatch(UserDeletionEventHandler handler) {
		handler.onUserDeletion(this);
	}

}
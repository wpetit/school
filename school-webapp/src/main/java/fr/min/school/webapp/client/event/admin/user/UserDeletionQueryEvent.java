/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class UserDeletionQueryEvent extends
		GwtEvent<UserDeletionQueryEventHandler> {
	public static Type<UserDeletionQueryEventHandler> TYPE = new Type<UserDeletionQueryEventHandler>();

	@Override
	public Type<UserDeletionQueryEventHandler> getAssociatedType() {
		return UserDeletionQueryEvent.TYPE;
	}

	@Override
	protected void dispatch(UserDeletionQueryEventHandler handler) {
		handler.onUserDeletionQuery(this);
	}

}
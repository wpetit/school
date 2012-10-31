/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class UserModificationQueryEvent extends
		GwtEvent<UserModificationQueryEventHandler> {
	public static Type<UserModificationQueryEventHandler> TYPE = new Type<UserModificationQueryEventHandler>();

	@Override
	public Type<UserModificationQueryEventHandler> getAssociatedType() {
		return UserModificationQueryEvent.TYPE;
	}

	@Override
	protected void dispatch(UserModificationQueryEventHandler handler) {
		handler.onUserModificationQuery(this);
	}

}
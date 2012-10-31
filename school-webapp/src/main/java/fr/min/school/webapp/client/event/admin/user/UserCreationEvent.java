/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class UserCreationEvent extends GwtEvent<UserCreationEventHandler> {
	public static Type<UserCreationEventHandler> TYPE = new Type<UserCreationEventHandler>();

	@Override
	public Type<UserCreationEventHandler> getAssociatedType() {
		return UserCreationEvent.TYPE;
	}

	@Override
	protected void dispatch(UserCreationEventHandler handler) {
		handler.onUserCreation(this);
	}

}
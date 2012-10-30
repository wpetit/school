/**
 * 
 */
package fr.min.school.webapp.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Wilfried Petit
 * 
 */
public class UserCreationQueryEvent extends
		GwtEvent<UserCreationQueryEventHandler> {
	public static Type<UserCreationQueryEventHandler> TYPE = new Type<UserCreationQueryEventHandler>();

	@Override
	public Type<UserCreationQueryEventHandler> getAssociatedType() {
		return UserCreationQueryEvent.TYPE;
	}

	@Override
	protected void dispatch(UserCreationQueryEventHandler handler) {
		handler.onUserCreationQuery(this);
	}

}
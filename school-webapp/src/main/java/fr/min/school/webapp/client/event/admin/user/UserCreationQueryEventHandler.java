/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Wilfried Petit
 * 
 */
public interface UserCreationQueryEventHandler extends EventHandler {
	void onUserCreationQuery(UserCreationQueryEvent event);
}

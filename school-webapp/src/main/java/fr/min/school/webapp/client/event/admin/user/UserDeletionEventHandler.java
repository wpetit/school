/**
 * 
 */
package fr.min.school.webapp.client.event.admin.user;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Wilfried Petit
 * 
 */
public interface UserDeletionEventHandler extends EventHandler {
	void onUserDeletion(UserDeletionEvent event);
}

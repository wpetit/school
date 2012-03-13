package fr.min.school.webapp.client.admin;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AuthenticationService</code>.
 */
public interface UserServiceAsync {
	void login(String name, String password, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}

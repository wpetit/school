package fr.min.school.webapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AuthenticationService</code>.
 */
public interface AuthenticationServiceAsync {
	void login(String name, String password, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}

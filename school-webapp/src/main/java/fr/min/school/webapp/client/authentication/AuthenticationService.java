package fr.min.school.webapp.client.authentication;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the authentication RPC service.
 * 
 * @author Wilfried Petit
 */
@RemoteServiceRelativePath("authenticationService")
public interface AuthenticationService extends RemoteService {

	/**
	 * Try to authenticate the user by its login/password.
	 * 
	 * @param login
	 *            the user login.
	 * @param password
	 *            the user password.
	 * @return the text "Hello, login" if the user has been successfully
	 *         authenticated.
	 * @throws IllegalArgumentException
	 *             if the login or the password are invalid.
	 */
	String authenticate(final String login, final String password)
			throws IllegalArgumentException;

}

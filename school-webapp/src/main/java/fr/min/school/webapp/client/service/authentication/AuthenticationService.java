package fr.min.school.webapp.client.service.authentication;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.min.school.model.dto.UserDTO;

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
	 * @return the user logged in.
	 * @throws IllegalArgumentException
	 *             if the login or the password are invalid.
	 */
	UserDTO authenticate(final String login, final String password)
			throws IllegalArgumentException;

}

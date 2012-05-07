package fr.min.school.webapp.client.authentication;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("authenticationService")
public interface AuthenticationService extends RemoteService {
	String authenticate(final String login, final String password)
			throws IllegalArgumentException;
}

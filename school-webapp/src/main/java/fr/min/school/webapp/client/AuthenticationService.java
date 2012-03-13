package fr.min.school.webapp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("authentication")
public interface AuthenticationService extends RemoteService {
	void login(String login, String password) throws IllegalArgumentException;
}

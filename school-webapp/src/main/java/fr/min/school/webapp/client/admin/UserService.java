package fr.min.school.webapp.client.admin;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("authentication")
public interface UserService extends RemoteService {
	void login(String login, String password) throws IllegalArgumentException;
}

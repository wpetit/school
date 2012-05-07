package fr.min.school.webapp.server.authentication;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.min.school.business.UserBusiness;
import fr.min.school.model.dto.UserDTO;
import fr.min.school.webapp.client.authentication.AuthenticationService;
import fr.min.school.webapp.shared.AuthenticationVerifier;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AuthenticationServiceImpl extends RemoteServiceServlet implements
		AuthenticationService {

	/** User Business services **/
	private UserBusiness userBusiness;

	public String authenticate(final String login, final String password)
			throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!AuthenticationVerifier.isValidLogin(login)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		} else if (!AuthenticationVerifier.isValidPassword(password)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Password must be at least 8 characters long");
		} else {
			final UserDTO userDTO = userBusiness.findUserByLoginPassword(login,
					password);

			if (userDTO == null) {
				throw new IllegalArgumentException("Invalid login/password");
			} else {
				return "Hello, " + userDTO.getLogin();
			}
		}
	}

	/**
	 * Return the AuthenticationServiceImpl userBusiness.
	 * 
	 * @return the userBusiness
	 */
	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	/**
	 * Set the AuthenticationServiceImpl userBusiness.
	 * 
	 * @param userBusiness
	 *            the userBusiness to set
	 */
	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

}

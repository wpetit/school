package fr.min.school.webapp.server.authentication;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

	@Override
	public String authenticate(final String login, final String password)
			throws IllegalArgumentException {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		userBusiness = (UserBusiness) ctx.getBean("userBusiness");

		// Verify that the input is valid.
		checkLoginAndPassword(login, password);

		// Retrieve the user associated to these informations.
		final UserDTO userDTO = userBusiness.findUserByLoginPassword(login,
				password);
		if (userDTO == null) {
			throw new IllegalArgumentException("Invalid login or password.");
		} else {
			return "Hel, " + userDTO.getLogin();
		}
	}

	/**
	 * Check login and password if at least one of them is invalid then an
	 * {@link IllegalArgumentException} is thrown.
	 * 
	 * @param login
	 *            the login to check.
	 * @param password
	 *            the password to check.
	 * @throws IllegalArgumentException
	 *             if at least one of the parameters is invalid.
	 */
	private void checkLoginAndPassword(String login, String password)
			throws IllegalArgumentException {
		if (!AuthenticationVerifier.isValidLogin(login)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Login must be at least 4 characters long.");
		} else if (!AuthenticationVerifier.isValidPassword(password)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Password must be at least 8 characters long.");
		}
	}

}

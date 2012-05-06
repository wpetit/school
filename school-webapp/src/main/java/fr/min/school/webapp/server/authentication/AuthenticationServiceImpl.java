package fr.min.school.webapp.server.authentication;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.min.school.webapp.client.authentication.AuthenticationService;
import fr.min.school.webapp.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AuthenticationServiceImpl extends RemoteServiceServlet implements
		AuthenticationService {

	public String authenticate(String login, final String password)
			throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(login)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		final String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		login = escapeHtml(login);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + login + "!<br>Your password is : " + password
				+ ".<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html
	 *            the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(final String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}

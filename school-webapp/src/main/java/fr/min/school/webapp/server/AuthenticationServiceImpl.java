package fr.min.school.webapp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.min.school.webapp.client.AuthenticationService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AuthenticationServiceImpl extends RemoteServiceServlet implements
		AuthenticationService {

	private static String toto = "tot";

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		/*
		 * if (!FieldVerifier.isValidName(input)) { // If the input is not
		 * valid, throw an IllegalArgumentException back to // the client. throw
		 * new IllegalArgumentException(
		 * "Name must be at least 4 characters long"); }
		 */

		final String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script
		// vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
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

	/**
	 * @see fr.min.school.webapp.client.AuthenticationService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void login(final String login, final String password)
			throws IllegalArgumentException {
		System.out.println(login);
		System.out.println(password);
	}
}

package fr.min.school.webapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

import fr.min.school.webapp.client.authentication.AuthenticationPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SchoolWebapp implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	public static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/** Central Panel **/
	private Panel centralPanel;

	/** Authentication Panel **/
	private Panel authenticationPanel;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		centralPanel = RootPanel.get("centralPanel");
		authenticationPanel = new AuthenticationPanel();
		centralPanel.add(authenticationPanel);
	}
}

package fr.min.school.webapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

import fr.min.school.webapp.client.authentication.AuthenticationPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SchoolWebapp implements EntryPoint {

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
